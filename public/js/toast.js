const Toast = {
    init() {
        this.hideTimeout = null
        this.el = document.createElement('div')
        this.el.className = 'toast'
        document.body.appendChild(this.el)
    },

    show(message, state) {
        clearTimeout(this.hideTimeout)
        this.el.textContent = message
        this.el.className = 'toast toat--visible'
    }
}

document.addEventListener('DOMContentLoaded', () => Toast.init())