package main

import "testing"

func TestAddItem(t *testing.T) {
	items = nil

	err := AddItem(Item{1, "Laptop", 5, 50000})

	if err != nil {
		t.Errorf("AddItem failed: %v", err)
	}

	if len(items) != 1 {
		t.Errorf("Expected 1 item, got %d", len(items))
	}
}

func TestUpdateItem(t *testing.T) {
	items = nil
	AddItem(Item{1, "Laptop", 5, 50000})

	err := UpdateItem(1, 10, 55000)

	if err != nil {
		t.Errorf("UpdateItem failed: %v", err)
	}

	if items[0].Quantity != 10 {
		t.Errorf("Expected quantity 10, got %d", items[0].Quantity)
	}
}

func TestRemoveItem(t *testing.T) {
	items = nil
	AddItem(Item{1, "Laptop", 5, 50000})

	err := RemoveItem(1)

	if err != nil {
		t.Errorf("RemoveItem failed: %v", err)
	}

	if len(items) != 0 {
		t.Errorf("Expected 0 items, got %d", len(items))
	}
}
