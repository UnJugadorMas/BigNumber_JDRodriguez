class BigNumber {
    public String number;

    // Constructor 1
    public BigNumber(String s) {
        this.number = s;
    }

    // Constructor 2
    public BigNumber(BigNumber b) {

    }
    // Suma

    BigNumber add(BigNumber other) {
        BigNumber addition = new BigNumber("");
        int carry = 0;

        if (this.number.charAt(0) == '0') {
            this.RemoveZeros(this);
        }
        if (other.number.charAt(0) == '0') {
            other.RemoveZeros(other);
        }

        if (this.number.charAt(0) == '0' && other.number.charAt(0) == '0') {
            addition.number = "0";
        } else {
            if (this.number.charAt(0) == '0' && other.number.charAt(0) != '0') {
                addition.number = other.number;
            } else {
                if (this.number.charAt(0) != '0' && other.number.charAt(0) == '0') {
                    addition.number = this.number;
                } else {
                    if (this.number.length() == other.number.length()) {
                        for (int i = this.number.length() - 1; i >= 0; i--) {
                            char char1 = this.number.charAt(i);
                            char char2 = other.number.charAt(i);
                            char add = (char) (char1 + char2 - 48 + carry);
                            if (carry == 1) carry--;
                            if (add >= 58) {
                                add = (char) (add - 10);
                                carry++;
                            }
                            addition.number += add;
                            if (carry == 1 && i == 0) addition.number += carry;
                        }
                    }

                    if (this.number.length() > other.number.length()) {
                        other.AddZeros(this);
                        for (int i = this.number.length() - 1; i >= 0; i--) {
                            char char1 = this.number.charAt(i);
                            char char2 = other.number.charAt(i);
                            char add = (char) (char1 + char2 - 48 + carry);
                            if (carry == 1) carry--;
                            if (add >= 58) {
                                add = (char) (add - 10);
                                carry++;
                            }
                            addition.number += add;
                            if (carry == 1 && i == 0) addition.number += carry;
                        }
                    }

                    if (this.number.length() < other.number.length()) {
                        this.AddZeros(other);
                        for (int i = this.number.length() - 1; i >= 0; i--) {
                            char char1 = this.number.charAt(i);
                            char char2 = other.number.charAt(i);
                            char add = (char) (char1 + char2 - 48 + carry);
                            if (carry == 1) carry--;
                            if (add >= 58) {
                                add = (char) (add - 10);
                                carry++;
                            }
                            addition.number += add;
                            if (carry == 1 && i == 0) addition.number += carry;
                        }
                    }

                    addition.InvertString(addition);}
            }
        }

        System.out.println(addition.number);
        return addition;

    }


    // Resta
    BigNumber sub(BigNumber other) {
        return null;
    }

    // Multiplica
    BigNumber mult(BigNumber other) {
        return null;
    }

    // Divideix
    BigNumber div(BigNumber other) {
        return null;
    }

    // Arrel quadrada
    BigNumber sqrt() {
        return null;
    }

    // Potència
    BigNumber power(int n) {
        return null;
    }

    // Factorial
    BigNumber factorial() {
        return null;
    }

    // MCD. Torna el Màxim comú divisor
    BigNumber mcd(BigNumber other) {
        return null;
    }

    // Compara dos BigNumber. Torna 0 si són iguals, -1
// si el primer és menor i torna 1 si el segon és menor
    public int compareTo(BigNumber other) {
        return -1;
    }

    // Torna un String representant el número
    public String toString() {
        return "";
    }

    // Mira si dos objectes BigNumber són iguals
    @Override
    public boolean equals(Object other) {
        if (other instanceof BigNumber) {
            BigNumber o = (BigNumber) other;
            if (this.number.charAt(0) == '0') {
                this.RemoveZeros(this);
            }

            if (o.number.charAt(0) == '0') {
                o.RemoveZeros(o);
            }

            if (this.number.charAt(0) == '0' && o.number.charAt(0) == '0') return true;

            return this.number.equals(o.number);
        }
        return false;
    }

    public void RemoveZeros(BigNumber b) {
        BigNumber NoZero = new BigNumber("");
        for (int i = 0 ; i < b.number.length(); i++) {
            if (b.number.charAt(i) != '0') {
                for (int j = i; j < b.number.length() ; j++) {
                    NoZero.number += b.number.charAt(j);
                }
                b.number = NoZero.number;
                break;
            }
        }
    }

    public void AddZeros(BigNumber b) {
        BigNumber WithZeros = new BigNumber("");
        int diff = b.number.length() - this.number.length();
        for (int i = 0; i < diff ; i++) {
            WithZeros.number += 0;
        }
        WithZeros.number += this.number;
        this.number = WithZeros.number;
    }
    public void InvertString(BigNumber b)   {
        BigNumber Invert = new BigNumber("");
        for (int i = b.number.length()-1; i >= 0 ; i--) {
            Invert.number += b.number.charAt(i);
        }
        b.number = Invert.number;
    }


}