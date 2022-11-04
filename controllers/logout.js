/*
Gets rid of our 'logged in' cookie so the web page will know we are no longer logged in
*/

const logout = (req, res) => {
    // remove cookie
    res.clearCookie("userRegistered")

    // show login page again
    res.redirect("/login")
}

module.exports = logout