public class TrainLine {

    private static final String EMPTY_LINE = "This line is empty.";

    /** Points to first station in the train line */
    private Station head;

    /**
     * Points to the last station and facilitates O(1) performance when adding
     * a new station at the end of the line
     */
    private Station tail;

    /** Current number of stations in this object */
    private int numberOfStations;

    /** Default constructor - redundant but good to show intent */
    public TrainLine() {
        this.head = null;
        this.tail = null;
        this.numberOfStations = 0;
    } // default constructor

    /**
     * Add a new station at the end of this trainline. The method creates
     * a new station object, first, with the given name. Then it checks to
     * if this line has a head station yet; if not, the new station becomes
     * the head station. If this line has a head station, the method begins
     * traversing this line from its head station, following the next points
     * untils it finds a station whose next is null. That station, by definition
     * is presently the last station in the line. The new station is added after
     * that last station.
     * 
     * @param name String with name of new station to add
     */
    public void addStation(String name) {
        // Create a new station object with the given name
        Station newStation = new Station(name);
        // Check if this trainline has a head station yet or not
        if (this.head == null) {
            // There is no head station in this trainline. Make the
            // new station, just created, the head station and also
            // the tail station of the line and we are done.
            this.head = newStation;
            this.tail = newStation;
        } else {
            // The trainline has an existing head station. Therefore,
            // it also has a known last station (this.tail).
            this.tail.setNext(newStation); // add new station after tail station
            this.tail = newStation; // Designate newly added station as tail station
        }
        // Update station counter
        this.numberOfStations++;
    } // method addStation

    /**
     * Accessor for this.numberOfStations
     * 
     * @return int with number of stations presently in this TrainLine
     */
    public int getNumberOfStations() {
        return this.numberOfStations;
    } // method getNumberOfStations

    /**
     * Determines if a station with a specific name is present in this TrainLine
     * 
     * @param stationName String with station name to search for
     * @return true if station found; false otherwise or if object has no stations.
     */
    public boolean contains(String stationName) {
        //initialize boolean 
        boolean found = false;
        //indexOf compares each station in a TrainLine to the string param and if there is
        //a match returns its index and if there is no match returns -1 so if index != -1
        //then stationName exists on the TrainLine
        int index = indexOf(stationName);
        if (index != -1){
           found = true;    
        }
        return found;
    } // method contains

    /**
     * Inserts a new station after an existing one.
     * 
     * @param existingStationName String with name of existing station that we
     *                            are adding a station after.
     * @param stationToAdd        String with name of new station to add.
     * @return true if insertion is successful, false if there is a problem.
     *         Potential problems inlude the presence of the station we are trying
     *         to add, the absence of the station we are trying to add after, and
     *         null/empty strings.
     */
    public boolean addAfter(String existingStationName, String stationToAdd) {
        boolean success = false;
        // Check if the station to add is already present in the TrainLine
        // object or if the supplied strings are null or empty.
        if (!this.contains(stationToAdd)
                && existingStationName != null && existingStationName.length() > 0
                && stationToAdd != null && stationToAdd.length() > 0) {
            // Traverse the TrainLine, looking for the existing station
            Station current = this.head;
            while (current != null) {
                // Check if the current station is the one we are looking for.
                // If the intended station is not found, we skill the if block,
                // the while-loop eventually ends, and we return the intial
                // value of success which is still false.
                if (current.getName().equals(existingStationName)) {
                    // Intended station found, time to get things going, first
                    // by creating the new station to insert.
                    Station newStation = new Station(stationToAdd);
                    // Make the new station point to where the existing station points
                    newStation.setNext(current.getNext());
                    // Make the existing station point to the new station
                    current.setNext(newStation);
                    // Update the return variable to indicate a successful insertion
                    success = true;
                }
            }
        }
        return success;
    } // method addAfter

    /**
     * Textual representation of this TrainLine
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.head == null) {
            sb.append(EMPTY_LINE);
        } else {
            Station current = this.head;
            while (current.hasNext()) {
                sb.append(String.format("[ %s ] --> ", current.getName()));
                current = current.getNext();
            }
            // Treat the last station in the line
            sb.append(String.format("[ %s ]", tail.getName()));
        }
        return sb.toString();
    } // method toString

    /** STUB FOR indexOf */
    /**
     * returns the numeric position of a station with a specified name 
     * @param name
     * @return position (int) or -1
     */
    public int indexOf(String name) {
        //Create and initialize index 
        int index = -1;
        boolean match = false;
        //Create and initializes current with this.head so the loop can start at the head station
        Station current = this.head;
        //Use a while loop to traverse the TrainLine object
        //The while loop ends when either the name is found in the TrainLine or 
        //the entire TrainLine is traversed without the name being found, we know there are 
        // no more stations when the current station's pointer is null
        while (!match && current != null){
            //adds one to index to account for the stations's position
            //head station is 0 
            index++;
            //compares the current station's name to the @parm and returns true or false
            match = current.getName().equals(name);
            //sets the current station to the station after the current station
            current = current.getNext();
        }
        //if a match was not found index is set to -1
        if (match == false){
            index = -1;
        }
        //return the value of index which represents the index of the param 
        return index;
        //
    } // method indexOf
}
