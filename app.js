// NOTES
// cookies: application --> cookies
// http requests: network

const express = require("express")
const path = require("path")
const cookie = require("cookie-parser")

// create app
const app = express()

// using ejs pages
app.set("view engine", "ejs")

// static files (css, js)
const publicDirectory = path.join(__dirname, 'public')
app.use(express.static(publicDirectory))

// cookies
app.use(cookie())
app.use(express.urlencoded({extended: false}))
app.use(express.json())

// use routes for serving html
app.use('/', require('./routes/pages'))

// handle all errorss
app.use((err, req, res, next) => {
    console.error(err.stack)
    res.status(500).send('Something broke!')
})

// start app
app.listen(8080, () => {
    console.log("Listening on port 8080")
})