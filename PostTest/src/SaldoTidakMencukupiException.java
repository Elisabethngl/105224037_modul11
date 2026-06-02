class SaldoTidakMencukupiException extends Exception {
    private double kekurangan;
    
    public SaldoTidakMencukupiException(double kekurangan) {
        super("Saldo tidak mencukupi! Kekurangan: Rp " + kekurangan);
        this.kekurangan = kekurangan;
    }
    
    public double getKekurangan() {
        return kekurangan;
    }
}
