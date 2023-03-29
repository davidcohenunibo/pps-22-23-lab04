package a01a

import org.junit.Test
import u04lab.polyglot.a01a.{Logics, LogicsImpl}
import org.junit.Assert.*

class LogicsTest:

  @Test def testHit(): Unit =
    val logics = LogicsImpl(3,4)
    assertEquals(Logics.Result.HIT,logics.hit(3,4))

    

