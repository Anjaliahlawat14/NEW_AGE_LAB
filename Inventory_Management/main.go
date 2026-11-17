package main

import (
	"errors"
	"fmt"
	"sync"
)

type Item struct {
	ID       int
	Name     string
	Quantity int
	Price    float64
}

var items []Item

func AddItem(item Item) error {
	if item.ID <= 0 || item.Name == "" || item.Quantity < 0 || item.Price <= 0 {
		return errors.New("invalid item details")
	}

	for _, i := range items {
		if i.ID == item.ID {
			return errors.New("item ID already exists")
		}
	}

	items = append(items, item)
	return nil
}

func UpdateItem(id int, quantity int, price float64) error {
	if quantity < 0 || price <= 0 {
		return errors.New("invalid quantity or price")
	}

	for index := range items {
		if items[index].ID == id {
			items[index].Quantity = quantity
			items[index].Price = price
			return nil
		}
	}

	return errors.New("item not found")
}

func RemoveItem(id int) error {
	for index, item := range items {
		if item.ID == id {
			items = append(items[:index], items[index+1:]...)
			return nil
		}
	}

	return errors.New("item not found")
}

func DisplayItems() {
	fmt.Println("\nInventory Items:")
	for _, item := range items {
		fmt.Printf("ID: %d, Name: %s, Quantity: %d, Price: %.2f\n",
			item.ID, item.Name, item.Quantity, item.Price)
	}
}

type Summary struct {
	ItemCount  int
	TotalValue float64
}

func CalculateSummary(ch chan Summary) {
	var total float64

	for _, item := range items {
		total += float64(item.Quantity) * item.Price
	}

	ch <- Summary{
		ItemCount:  len(items),
		TotalValue: total,
	}
}

func main() {
	fmt.Println("INVENTORY MANAGEMENT SYSTEM")

	fmt.Println("\nAdding Items:")

	err := AddItem(Item{1, "Laptop", 5, 50000})
	if err != nil {
		fmt.Println(err)
	} else {
		fmt.Println("Laptop added successfully")
	}

	err = AddItem(Item{2, "Mouse", 10, 500})
	if err != nil {
		fmt.Println(err)
	} else {
		fmt.Println("Mouse added successfully")
	}

	fmt.Println("\nUpdating Item:")
	err = UpdateItem(1, 8, 32000)
	if err != nil {
		fmt.Println(err)
	} else {
		fmt.Println("Laptop updated successfully")
	}

	fmt.Println("\nRemoving Item:")
	err = RemoveItem(2)
	if err != nil {
		fmt.Println(err)
	} else {
		fmt.Println("Mouse removed successfully")
	}

	DisplayItems()

	fmt.Println("\nInventory Summary:")

	ch := make(chan Summary)
	var wg sync.WaitGroup

	wg.Add(1)
	go func() {
		defer wg.Done()
		CalculateSummary(ch)
	}()

	summary := <-ch
	wg.Wait()
	close(ch)

	fmt.Println("Total Items:", summary.ItemCount)
	fmt.Printf("Total Inventory Value: %.2f\n", summary.TotalValue)
}
