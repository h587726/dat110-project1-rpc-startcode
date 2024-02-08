package no.hvl.dat110.messaging;

import java.util.Arrays;

import no.hvl.dat110.TODO;

public class MessageUtils {

	public static final int SEGMENTSIZE = 128;

	public static int MESSAGINGPORT = 8080;
	public static String MESSAGINGHOST = "localhost";

	public static byte[] encapsulate(Message message) {
		
		byte[] segment = null;
		byte[] data;
		
		// TODO - START
		data = message.getData();
		segment = new byte[SEGMENTSIZE];


		// encapulate/encode the payload data of the message and form a segment
		// according to the segment format for the messaging layer
		segment[0] = (byte) data.length;

		byte count = 1;
		for (byte i : data) {

            segment[count] = i;
			count++;
		}
			
		// TODO - END
		return segment;
	}

	public static Message decapsulate(byte[] segment) {

		Message message = null;

		// TODO - START
		// decapsulate segment and put received payload data into a message
		byte count = 1;
		byte datalength = segment[0];
		byte[] data = new byte[datalength];


		for (int i = 0; i < data.length; i++) {

			data[i] = segment[count];
			count++;
		}


		//System.arraycopy(segment, 1, data, 0, datalength);

		message = new Message(data);
		// TODO - END

		return message;
	}
	
}
