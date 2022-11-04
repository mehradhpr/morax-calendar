const jwt = require("jsonwebtoken")
const db = require("../database")
const bcrypt = require("bcryptjs")

/*
Check to see if login credentials are correct
If so, create a cookie showing that this user is logged in
*/

const login = async (req, res) => {
    // grab info from web page
    const {email, username, password} = req.body

    // if missing an email or password, failed
    if (!email || !password) res.redirect('/login')
    else {
        // check if email exists in MySQL
        db.query('SELECT * FROM user WHERE email = ?', [email], async (err, result) => {
            if (err) throw err
            // if no user, or password missmatch login fails
            if(!result[0] || !await bcrypt.compare(password, result[0].password)) res.redirect('/login')
            // login
            else {
                // create jwt
                const token = jwt.sign({id: result[0].id}, process.env.JWT_SECRET, {
                    expiresIn:process.env.JWT_EXPIRES,
                })
                // create cookie
                const cookieOptions = {
                    expiresIn: new Date(Date.now() + process.env.COOKIE_EXPIRES * 24 * 60 * 60 * 1000),
                    httpOnly: true
                }
                // set cookie
                res.cookie("userRegistered", token, cookieOptions)
                res.redirect('/login')
            }
        })
    }
}

module.exports = login