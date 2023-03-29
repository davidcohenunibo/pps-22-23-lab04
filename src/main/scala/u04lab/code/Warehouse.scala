package u04lab.code
import u04lab.code.List.*
trait Item {
  def code: Int
  def name: String
  def tags: List[String]
}

object Item:

  //* - Refactor the code of Item accepting a variable number of tags (hint: use _*)
  def apply(code: Int, name: String, tags:String*): Item = ItemImpl(code, name, List.fromSeq(tags))
  def apply(code: Int, name: String, tags:List[String]): Item = ItemImpl(code, name, tags)

  private case class ItemImpl(
                               override val code: Int,
                               override val name: String,
                               override val tags:List[String]) extends Item

/**
 * A warehouse is a place where items are stored.
 */
trait Warehouse:
  /**
   * Stores an item in the warehouse.
   * @param item the item to store
   */
  def store(item: Item): Unit
  /**
   * Searches for items with the given tag.
   * @param tag the tag to search for
   * @return the list of items with the given tag
   */
  def searchItems(tag: String): List[Item]
  /**
   * Retrieves an item from the warehouse.
   * @param code the code of the item to retrieve
   * @return the item with the given code, if present
   */
  def retrieve(code: Int): Option[Item]
  /**
   * Removes an item from the warehouse.
   * @param item the item to remove
   */
  def remove(item: Item): Unit
  /**
   * Checks if the warehouse contains an item with the given code.
   * @param itemCode the code of the item to check
   * @return true if the warehouse contains an item with the given code, false otherwise
   */
  def contains(itemCode: Int): Boolean


object Warehouse:
  def apply(): Warehouse = WarehouseImpl()

  private case class WarehouseImpl() extends Warehouse:

    private var _items: List[Item] = List.empty
    override def store(item: Item): Unit = { _items = List.add(_items,item) }
    override def searchItems(tag: String): List[Item] = List.filter(_items)( i => List.contains(i.tags,tag))
    override def retrieve(code: Int): Option[Item] = List.find(_items)( _.code == code)
    override def remove(item: Item): Unit = {_items = List.remove(_items)(_ == item) }
    override def contains(itemCode: Int): Boolean = List.contains(List.flatMap(_items)(i => Cons(i.code, Nil())),itemCode)
