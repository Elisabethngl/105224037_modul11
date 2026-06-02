class AkunBank {
    String nomorRekening;
    double saldo;
    double totalTransferHariIni;
    double limitTransferHarian = 10000000; 
    public AkunBank(String nomorRekening, double saldo) {
        this.nomorRekening = nomorRekening;
        this.saldo = saldo;
        this.totalTransferHariIni = 0;
    }

    public void tarikTunai(double nominal) throws SaldoTidakMencukupiException {
        if (nominal > saldo) {
            double kekurangan = nominal - saldo;
            throw new SaldoTidakMencukupiException(kekurangan);
        }
        saldo -= nominal;
        System.out.println("Penarikan Rp " + nominal + " berhasil. Sisa saldo: Rp " + saldo);
    }

    public void transfer(AkunBank tujuan, double nominal) 
            throws SaldoTidakMencukupiException, BatasTransferHarianException {
        
        if (nominal > saldo) {
            double kekurangan = nominal - saldo;
            throw new SaldoTidakMencukupiException(kekurangan);
        }
        
        if (totalTransferHariIni + nominal > limitTransferHarian) {
            throw new BatasTransferHarianException(limitTransferHarian);
        }
        
        saldo -= nominal;
        tujuan.saldo += nominal;
        totalTransferHariIni += nominal;
        System.out.println("Transfer Rp " + nominal + " ke rekening " + 
            tujuan.nomorRekening + " berhasil. Sisa saldo: Rp " + saldo);
    }
}
