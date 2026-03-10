package baitapluyen2;

class Computer {
    // Các thuộc tính
    private String HDD;
    private String RAM;
    private boolean isBluetoothEnabled;
    
    private Computer(ComputerBuilder builder) {
        this.HDD = builder.HDD;
        this.RAM = builder.RAM;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
    }

    @Override
    public String toString() {
        return "Computer [HDD=" + HDD + ", RAM=" + RAM + ", Bluetooth=" + isBluetoothEnabled + "]";
    }

    public static class ComputerBuilder {
        private String HDD;
        private String RAM;
        private boolean isBluetoothEnabled;

        public ComputerBuilder(String hdd, String ram) {
            this.HDD = hdd;
            this.RAM = ram;
        }

        public ComputerBuilder setBluetoothEnabled(boolean isBluetoothEnabled) {
            this.isBluetoothEnabled = isBluetoothEnabled;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}

public class Bai2 {
    public static void main(String[] args) {
        Computer pc1 = new Computer.ComputerBuilder("500GB", "16GB")
                .setBluetoothEnabled(true)
                .build();

        Computer pc2 = new Computer.ComputerBuilder("1TB", "8GB")
                .build();

        System.out.println(pc1);
        System.out.println(pc2);
    }
}