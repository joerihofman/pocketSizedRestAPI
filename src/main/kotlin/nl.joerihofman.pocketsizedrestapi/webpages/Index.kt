package nl.joerihofman.pocketsizedrestapi.webpages

import io.ktor.html.Template
import io.ktor.html.insert
import kotlinx.html.*


class Index(val mainTemplate: MainTemplate = MainTemplate()): Template<HTML> {

    override fun HTML.apply() {
        insert(mainTemplate) {
            header {
                title("INDEX")

            }
            content {
                script {
                    + "function myFun() { document.getElementById('button').innerHTML = 'YOU CLICKED ME!' ;}"
                }
                div("main") {
                    h1 { +"Hello World!" }
                    br
                    button(type = ButtonType.button) {
                        id = "button"
                        onClick = "myFun()"
                        + "TEST"
                    }
                }
            }
        }
    }

}
