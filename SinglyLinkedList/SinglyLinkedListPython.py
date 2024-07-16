def main():
    sll = SinglyLinkedList()
    Testing(sll)
    """
    Expected print statements:
    [10, 5]
    [5]
    []
    Can't remove from empty list
    []
    [7, 8, 9]
    [3, 7, 5, 8, 9, 4]
    0
    2
    5
    -1
    [7, 8, 9]
    []
    Index is outside of linked list
    [9, 6]
    [9]
    []
    Can't remove from empty list
    []

    Should any mismatch of print statements occur, check Testing function.
    """

def Testing(sll):
    sll.InsertFront(5)
    sll.InsertFront(10)
    sll.PrintList() # [10, 5]
    sll.RemoveFront()
    sll.PrintList() # [5]
    sll.RemoveFront()
    sll.PrintList() # []
    sll.RemoveFront() # Can't remove from empty list
    sll.PrintList() # []
    sll.InsertAtIndex(7, 0)
    sll.InsertAtIndex(8, 1)
    sll.InsertAtIndex(9, 2)
    sll.PrintList() # [7, 8, 9]
    sll.InsertAtIndex(3, 0)
    sll.InsertAtIndex(4, sll.length)
    sll.InsertAtIndex(5, 2)
    sll.PrintList() # [3, 7, 5, 8, 9, 4]
    print(sll.Search(3)) # 0
    print(sll.Search(5)) # 2
    print(sll.Search(4)) # 5
    print(sll.Search(100)) # -1
    sll.RemoveAtIndex(2)
    sll.RemoveAtIndex(sll.length-1)
    sll.RemoveAtIndex(0)
    sll.PrintList(); # [7, 8, 9]
    sll.RemoveAtIndex(2)
    sll.RemoveAtIndex(1)
    sll.RemoveAtIndex(0)
    sll.PrintList() # []
    sll.RemoveAtIndex(2) # Index is outside of linked list
    sll.InsertBack(9)
    sll.InsertBack(6)
    sll.PrintList() # [9, 6]
    sll.RemoveBack()
    sll.PrintList() # [9]
    sll.RemoveBack()
    sll.PrintList() # []
    sll.RemoveBack() # Can't remove from empty list
    sll.PrintList() # []

class SinglyLinkedList:
    def __init__(self):
        self.head = None
        self.tail = None
        self.length = 0

    def Search(self, value):
        if self.length == 0:
            return -1
        index = 0
        temp = self.head
        while temp != None:
            if temp.value == value:
                return index
            index += 1
            temp = temp.next
        return -1
    
    def InsertFront(self, value):
        if self.length == 0:
            self.head = Node(value)
        else:
            temp = Node(value)
            temp.next = self.head
            self.head = temp
        self.length += 1

    def InsertAtIndex(self, value, index):
        pass

    def InsertBack(self, value):
        pass

    def RemoveFront(self):
        pass

    def RemoveAtIndex(self, index):
        pass

    def RemoveBack(self):
        pass

    def PrintList(self):
        if self.length == 0:
            print("[]")
            return
        temp = self.head
        lst = "["
        while temp.next != None:
            lst += str(temp.value) + ", "
            temp = temp.next
        lst += str(temp.value)
        lst += "]"
        print(lst)

class Node:
    def __init__(self, value):
        self.value = value
        self.next = None

if __name__ == "__main__":
    main()