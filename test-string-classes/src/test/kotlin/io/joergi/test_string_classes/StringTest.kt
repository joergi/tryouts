package io.joergi.test_string_classes

import org.junit.jupiter.api.Test
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import com.google.common.truth.Truth.assertThat
import io.kotest.assertions.*
import io.kotest.matchers.equals.shouldBeEqual
import strikt.assertions.*
import strikt.api.*

class StringTest {

    // Minion text proudly presented by https://www.minionsipsum.com/
    val text1 = """Minions ipsum potatoooo belloo! Ti aamoo! La bodaaa hana dul sae me want bananaaa! Butt gelatooo chasy jiji. Ti aamoo! jeje potatoooo belloo! Ti aamoo! Daa gelatooo chasy. Bananaaaa wiiiii daa bananaaaa tatata bala tu. Para tú la bodaaa po kass tulaliloo bee do bee do bee do bappleees bappleees. Ti aa.jmoo! me want bananaaa! Ti aamoo! Tulaliloo bananaaaa. Para tú bee do bee do bee do bananaaaa la bodaaa bee do bee do bee do bee do bee do bee do tatata bala tu poulet tikka masala underweaaar. Bananaaaa underweaaar hahaha daa para tú pepete tatata bala tu belloo!""".trimIndent()
    val text2 = """Minions ipsum potatoooo belloo! Ti aamoo! La bodaaa hana dul sae me want bananaaa! Butt gelatooo chasy jiji. Ti aamoo! jeje potatoooo belloo! Ti aamoo! Daa gelatooo chasy. Bananaaaa wiiiii daa bananaaaa tatata bala tu. Para tú la bodaaa po kass tulaliloo bee do bee do bee do bappleees bappleees. Ti aamoo! me want bananaaa! Ti aamoo! Tulaliloo bananaaaa. Para tú bee do bee do bee do bananaaaa  la bodaaa bee do bee do bee do bee do bee do bee do tatata bala tu poulet tikka masala underweaaar. Bananaaaa underweaaar hahaha daa para tú pepete tatata bala tu belloo!""".trimIndent()

    @Test
    fun `compare 2 strings  with hamkrest`() {
        assertThat(text1, equalTo(text2))
    }

    @Test
    fun `compare 2 strings  with strikt_io`() {
        expectThat(text1).isEqualTo(text2)
    }

    @Test
    fun `compare 2 strings  with truth`() {
        assertThat(text1).isEqualTo(text2)
    }

    @Test
    fun `compare 2 strings  with kotest`() {
        text1 shouldBeEqual text2
    }


}