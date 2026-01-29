package com.Team01.DTO;

public class OrderDTO {
    private int orderId;
    private String type;
    private String foodItem;
    private int tableNo;

    
    public int getOrderId() 
    { 
        return orderId; 
    }
    
    public void setOrderId(int orderId) 
    { 
        this.orderId = orderId; 
    }

    public String getType() 
    { 
        return type; 
    }
    
    public void setType(String type) 
    { 
        this.type = type; 
    }

    public String getFoodItem() 
    { 
        return foodItem; 
    }
    
    public void setFoodItem(String foodItem) 
    { 
        this.foodItem = foodItem; 
    }

    public int getTableNo() 
    { 
        return tableNo; 
    }
    public void setTableNo(int tableNo) 
    { 
        this.tableNo = tableNo; 
    }
}