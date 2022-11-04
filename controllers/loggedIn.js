/* 
This will check if a user is currently logged in
user --> the returned user from MySQL database
*/
const db = require("../database")
const jwt = require("jsonwebtoken")

const loggedIn = (req, res, next) => {
    // user not logged in if no cookie
    if (!req.cookies.userRegistered) return next()
    try {
        // verify the users json web token with MySQL database
        const decoded = jwt.verify(req.cookies.userRegistered, process.env.JWT_SECRET)
        db.query('SELECT * from user WHERE id = ?', [decoded.id], (err, result) => {
            if (err) return next()
            req.user = result[0]
            return next()
        })
    } catch(error) {
        if (error) return next()
    }
}

module.exports = loggedIn