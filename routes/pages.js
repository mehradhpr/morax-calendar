const express = require("express")
const router = express.Router()
const loggedIn = require("../controllers/loggedIn")
const logout = require("../controllers/logout")
const login = require("../controllers/login")
const signup = require("../controllers/signup")

// logging in
router.post("/login", login, (req, res) => {
    if (req.status == "success") {
        res.render('../views/login', {status: "loggedIn", user:req.user})
    }
    else {
        res.render('../views/login', {status: "logIn", user: "null"})
    }
})

// signing up
router.post("/signup", signup,)

// showing login page, changes if already logged in
router.get('/login', loggedIn, (req, res) => {
    if (req.user) {
        res.render('../views/login', {status: "loggedIn", user:req.user})
    }
    else {
        res.render('../views/login', {status: "logIn", user: "null"})
    }
})

// showing signup page
router.get('/signup', (req, res) => {
    res.render('../views/signup')
})

// show about-us page
router.get('/about-us', (req, res) => {
    res.render('../views/about-us')
})

// show article page
router.get('/article', (req, res) => {
    res.render('../views/article')
})

// show arcticles page
router.get('/articles', (req, res) => {
    res.render('../views/articles')
})

// show contact-us page
router.get('/contact-us', (req, res) => {
    res.render('../views/contact-us')
})

// show home page
router.get('/index', loggedIn, (req, res) => {
    if(req.user) {
        res.render('../views/index', {status: "loggedIn", user:req.user})
    }
    else {
        res.render('../views/index', {status: "logIn", user: "null"})
    }
})

// log the user out
router.get('/logout', logout)

module.exports = router