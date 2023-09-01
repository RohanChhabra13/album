
package streams;

public class Flight {
	private int code;
	private String carrier;
	private String source;
	private String destination;
	
	public Flight() {
		// TODO Auto-generated constructor stub
	}

	public Flight(int code, String carrier, String source, String destination) {
		super();
		this.code = code;
		this.carrier = carrier;
		this.source = source;
		this.destination = destination;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Flight [code="+code+", carrier="+carrier+", source="+source+", destination"+destination+"]";
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
	

}
