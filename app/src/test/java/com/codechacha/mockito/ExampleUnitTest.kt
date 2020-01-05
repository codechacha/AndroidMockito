package com.codechacha.mockito

import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ExampleUnitTest {

    @Test
    fun example1() {
        val example = mock(Example::class.java)

        `when`(example.getId()).thenReturn(100)
        `when`(example.getUrl(100)).thenReturn("https://codechacha.com")

        assertEquals(100, example.getId())
        assertEquals("https://codechacha.com", example.getUrl(example.getId()))
    }


    @Test
    fun example2() {
        val example = mock(Example::class.java)

        `when`(example.getId()).thenReturn(100)
        `when`(example.getUrl(any())).thenReturn("https://codechacha.com")

        assertEquals(100, example.getId())
        assertEquals("https://codechacha.com", example.getUrl(0))
    }

    @Test
    fun example3() {
        val example = mock(Example::class.java)

        `when`(example.getUrl(anyInt())).thenReturn("https://codechacha.com")
        assertEquals("https://codechacha.com", example.getUrl(10))

        `when`(example.getUrl(20)).thenThrow(IllegalStateException("Exception happened!"))

        try {
            example.getUrl(20)
            fail()
        } catch (e: IllegalStateException) {
            assertEquals(e.message, "Exception happened!")
        }

        doReturn(30).`when`(example).getId()
        assertEquals(30, example.getId())
    }

    @Test
    fun example4() {
        val example = mock(Example::class.java)
        `when`(example.getId()).thenReturn(100)
        `when`(example.getUrl(100)).thenReturn("https://codechacha.com")

        example.getId()
        example.getId()
        val url = example.getUrl(example.getId())


        verify(example).getUrl(ArgumentMatchers.eq(100))
        verify(example, times(3)).getId()
        verify(example, atLeast(2)).getId()
        verify(example, atLeast(1)).getUrl(100)
    }
}