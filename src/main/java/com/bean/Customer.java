package com.bean;

public class Customer {
        private int customerId;
        private String customerName;
        private String customerEmail;
        private String customerPhoneNo;
        private String customerPassword;

        public Customer(int customerId,String customerName,String customerEmail,String customerPhoneNo,String customerPassword){
                this.customerId = customerId;
                this.customerName = customerName;
                this.customerEmail = customerEmail;
                this.customerPhoneNo = customerPhoneNo;
                this.customerPassword = customerPassword;
        }

        public Customer() {
			// TODO Auto-generated constructor stub
		}

		public int getCustomerId() {
                return customerId;
        }

        public String getCustomerName() {
                return customerName;
        }

        public String getCustomerEmail() {
                return customerEmail;
        }

        public String getCustomerPhoneNo() {
                return customerPhoneNo;
        }

        public String getCustomerPassword() {
                return customerPassword;
        }

        // Setters
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public void setCustomerPhoneNo(String customerPhoneNo) {
        this.customerPhoneNo = customerPhoneNo;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }
}