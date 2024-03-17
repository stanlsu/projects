public class Car implements Comparable<Car> {
		private String make;
	    private int year;
	    private int price;

	    public Car (String Make, int Year, int Price){
	        make = Make;
	        year = Year;
	        price = Price;
	    }

	    public String getMake() {
	        return make;
	    }

	    public int getYear() {
	        return year;
	    }

	    public int getPrice() {
	        return price;
	    }

	    public int compareTo(Car other) {
	        if (make.equals(other.make)) {
	            return Integer.compare(year, other.year);
	        } else {
	            return this.make.compareTo(other.make);
	        }
	    }


	    public String toString() {
	        return "Make: " + make + ", Year : " + year + ", Price: " + price + " ";
	    }

	}

