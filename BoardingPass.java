
public class BoardingPass {

    BoardingPass boardingPass;

    public BoardingPass(Passenger passenger, String gate) throws NullPointerException {
        if (passenger == null) {
            throw new NullPointerException();
        }
        setBoardingPass(passenger,gate);

    }

    public BoardingPass getBoardingPass() {
        return boardingPass;
    }

    public void setBoardingPass(Passenger passenger, String  gate) {
        boardingPass = boardingPass(passenger,gate);
    }

    private BoardingPass boardingPass(Passenger passenger, String gate) {
        return new BoardingPass(passenger,gate);
    }
}
