const db = require("../database")
const bcrypt = require("bcryptjs")
const { render } = require("ejs")

/*
This will create a user in our MySQL database
makes sure no one has used the given username yet
makes sure no one has used the given email yet
*/

const signup = async (req, res) => {
    // grab info from web page
    const { email, username, password: Npassword } = req.body

    // if missing any field signup fails
    if (!email || !Npassword || !username) res.redirect('/signup')

    // check if this username is already used
    db.query('SELECT username from user WHERE username = ?', [username], async (e, r) => {
        if(e) throw e
        if(r[0]) res.redirect('/signup')
    })
    // check if email is already used
    db.query('SELECT email FROM user WHERE email = ?', [email], async (err, result) => {
        if(err) throw err
        if(result[0])res.redirect('/signup')
        else{
            // create user
            const password = await bcrypt.hash(Npassword, 8)
            db.query('INSERT INTO user SET ?', {username: username, email: email, password: password}, (error, results) => {
                if(error) throw error
                else{
                    res.redirect('/login')
                }
            })
        }
    })
}

module.exports = signup