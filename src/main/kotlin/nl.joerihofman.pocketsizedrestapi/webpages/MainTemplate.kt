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
            insert(header)
        }
        body {
            style = "text-align:center;"
            insert(content)
        }
    }
}