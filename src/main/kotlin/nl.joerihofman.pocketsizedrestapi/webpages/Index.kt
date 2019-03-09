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
                    src = "js/main"
                }
                div("main") {
                    h1 { +"Hello World!" }
                    br
                    button(type = ButtonType.button) {
                        id = "button"
                        onClick = "changeButton()"
                        + "TEST"
                    }
                    br
                    br
                    div { id = "documentForm"; attributes["align"] = "center" }
                }
            }
        }
    }

}
