
import jssc.*;

import java.io.IOException;

public class Controller {


        public static void writeToPort() {

            // getting serial ports list into the array
            String[] portNames = SerialPortList.getPortNames();

            if (portNames.length == 0) {
                System.out.println("There are no serial-ports :( You can use an emulator, such ad VSPE, to create a virtual serial port.");
                System.out.println("Press Enter to exit...");
                try {
                    System.in.read();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                return;
            }

            for (int i = 0; i < portNames.length; i++) {
                System.out.println(portNames[i]);
            }

            SerialPort serialPort = new SerialPort("COM1");
            try {
                serialPort.openPort();

                serialPort.setParams(SerialPort.BAUDRATE_9600,
                        SerialPort.DATABITS_8,
                        SerialPort.STOPBITS_1,
                        SerialPort.PARITY_NONE);

                serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_RTSCTS_IN |
                        SerialPort.FLOWCONTROL_RTSCTS_OUT);

//                serialPort.addEventListener(new PortReader(), SerialPort.MASK_RXCHAR);

                serialPort.writeString("Buzeranti");
            }
            catch (SerialPortException ex) {
                System.out.println("There are an error on writing string to port т: " + ex);
            }
        }
    }


