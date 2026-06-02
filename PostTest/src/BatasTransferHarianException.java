class BatasTransferHarianException extends Exception {
    private double limitHarian;
    
    public BatasTransferHarianException(double limitHarian) {
        super("Transfer melebihi batas harian! Limit harian: Rp " + limitHarian);
        this.limitHarian = limitHarian;
    }
    
    public double getLimitHarian() {
        return limitHarian;
    }
}
