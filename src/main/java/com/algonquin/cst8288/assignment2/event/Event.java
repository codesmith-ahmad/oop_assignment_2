package com.algonquin.cst8288.assignment2.event;

public interface Event {
 
	/**
	 * @return the eventName
	 */
	public String getEventName();

	/**
	 * @param eventName the eventName to set
	 */
	public void setEventName(String eventName);

	/**
	 * @return the eventDescription
	 */
	public String getEventDescription();

	/**
	 * @param eventDescription the eventDescription to set
	 */
	public void setEventDescription(String eventDescription);

	/**
	 * @return the eventActivities
	 */
	public String getEventActivities();

	/**
	 * @param eventActivities the eventActivities to set
	 */
	public void setEventActivities(String eventActivities);

	/**
	 * @return the admissionFees
	 */
	public double getAdmissionFees();

	/**
	 * @param admissionFees the admissionFees to set
	 */
	public void setAdmissionFees(double admissionFees);

	// Every library as it own admission fee
	public double calculateAdmissionFee();

        public void displayInfo();
}
