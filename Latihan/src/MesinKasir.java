class MesinKasir {

    public void bayar(int totalBelanja, int uangDiberikan) throws UangKurangException {
        if (uangDiberikan < totalBelanja) {
            throw new UangKurangException(
                "Uang kurang! Total belanja: Rp " + totalBelanja + ", uang diberikan: Rp " + uangDiberikan
            );
        }
        int kembalian = uangDiberikan - totalBelanja;
        System.out.println("Pembayaran berhasil! Kembalian: Rp " + kembalian);
    }

    public void cetakStruk(boolean statusPrinter) throws Exception {
        if (!statusPrinter) {
            throw new Exception("Printer error: Kertas struk habis!");
        }
        System.out.println("Struk berhasil dicetak!");
    }
}
