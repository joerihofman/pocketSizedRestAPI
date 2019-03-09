package nl.joerihofman.pocketsizedrestapi.webpages

import io.ktor.html.Placeholder
import io.ktor.html.Template
import io.ktor.html.insert
import kotlinx.html.*

class MainTemplate: Template<HTML> {
    val content = Placeholder<HtmlBlockTag>()
    val header = Placeholder<HtmlHeadTag>()

    override fun HTML.apply() {
        head {
            link(rel = "stylesheet", href = "css/main", type = "text/css") //href: http://localhost:8088/css/main
            script { type = "text/javascript"; src = "js/jquery" }
            insert(header)
        }
        body {
            style = "text-align:center;"
            insert(content)
        }
    }
}