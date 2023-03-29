package a01a

import org.junit.Test
import org.junit.Assert.*
import u04lab.code.{Item, Warehouse, List,Option}
import u04lab.code.Warehouse.*
class WarehouseTest:

  val warehouse: Warehouse = Warehouse()
  val dellXps: Item = Item(33, "Dell XPS 15", "notebook")
  val dellInspiron: Item = Item(34, "Dell Inspiron 13", "notebook")
  val xiaomiMoped: Item = Item(35, "Xiaomi S1", "moped", "mobility")

  @Test def testContains(): Unit = 
    assertFalse(warehouse.contains(dellXps.code))
    warehouse.store(dellXps)
    assertTrue(warehouse.contains(dellXps.code))
  

  @Test def testStore(): Unit = 
    warehouse.store(dellXps)
    assertEquals(Option.Some(dellXps), warehouse.retrieve(dellXps.code))

  @Test def testRetrieve(): Unit =
    warehouse.store(dellXps)
    warehouse.store(dellInspiron)
    warehouse.store(xiaomiMoped)
    assertEquals(Option.Some(dellXps), warehouse.retrieve(dellXps.code))
    warehouse.remove(dellXps)
    assertEquals(Option.None(), warehouse.retrieve(dellXps.code))

  @Test def testSearchItems(): Unit =
    warehouse.store(dellXps)
    warehouse.store(dellInspiron)
    warehouse.store(xiaomiMoped)
    assertEquals(List.cons(xiaomiMoped,List.Nil()),warehouse.searchItems("mobility"))
    assertEquals(List.cons(dellXps,List.cons(dellInspiron,List.Nil())),warehouse.searchItems("notebook"))

  @Test def testRemove(): Unit = 
    warehouse.store(dellXps)
    warehouse.store(dellInspiron)
    assertEquals(List.cons(dellXps,List.cons(dellInspiron,List.Nil())),warehouse.searchItems("notebook"))
    warehouse.remove(dellXps)
    assertEquals(List.cons(dellInspiron,List.Nil()),warehouse.searchItems("notebook"))
    warehouse.remove(dellInspiron)
    assertEquals(List.Nil(),warehouse.searchItems("notebook"))

  @Test def behavior(): Unit =
    assertFalse(warehouse.contains(dellXps.code))
    warehouse.store(dellXps)
    assertTrue(warehouse.contains(dellXps.code))
    warehouse.store(dellInspiron)
    warehouse.store(xiaomiMoped)
    assertEquals(List.cons(xiaomiMoped,List.Nil()),warehouse.searchItems("mobility"))
    assertEquals(List.cons(dellXps,List.cons(dellInspiron,List.Nil())),warehouse.searchItems("notebook"))
    assertEquals(Option.None(),warehouse.retrieve(11))
    assertEquals(Option.Some(dellXps),warehouse.retrieve(dellXps.code))
    warehouse.remove(dellXps)
    assertEquals(Option.None(),warehouse.retrieve(dellXps.code))





