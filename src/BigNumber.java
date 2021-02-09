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

                    addition.InvertString(addition);
                }
            }
        }

        System.out.println(addition.number);
        return addition;

    }


    // Resta
    BigNumber sub(BigNumber other) {
        BigNumber sub = new BigNumber("");
        int carry = 0;

        if (this.number.charAt(0) == '0') {
            this.RemoveZeros(this);
        }

        if (other.number.charAt(0) == '0') {
            other.RemoveZeros(other);
        }

        if (this.number.charAt(0) == '0' && other.number.charAt(0) == '0') {
            sub.number = "0";
            return sub;
        }

        if (this.number.length() == other.number.length()) {
            for (int i = this.number.length() - 1; i >= 0; i--) {
                char char1 = this.number.charAt(i);
                char char2 = (char) (other.number.charAt(i) + carry);
                char subChar = 0;

                if (carry == 1) carry--;

                if (char2 > char1) {
                    subChar = (char) (58 - char2 + char1);
                    carry++;
                }

                if (char1 > char2) {
                    subChar = (char) (char1 - char2 + 48);
                }

                if (char1 == char2) {
                    subChar = 48;
                }

                sub.number += subChar;
            }
        }

        if (this.number.length() > other.number.length()) {
            other.AddZeros(this);
            for (int i = this.number.length() - 1; i >= 0; i--) {
                char char1 = this.number.charAt(i);
                char char2 = (char) (other.number.charAt(i) - carry);
                char subChar = 0;
                if (carry == -1) carry++;
                if (char2 > char1) {
                    subChar = (char) (58 - char2 + char1);
                    carry--;
                }

                if (char1 > char2) {
                    subChar = (char) (char1 - char2 + 48);
                }

                if (char1 == char2) {
                    subChar = 48;
                }


                sub.number += subChar;


            }
        }

        if (this.number.length() < other.number.length()) {
            this.AddZeros(other);
            for (int i = this.number.length() - 1; i >= 0; i--) {
                char char1 = this.number.charAt(i);
                char char2 = (char) (other.number.charAt(i) - carry);
                char subChar = 0;
                if (carry == -1) carry++;
                if (char2 > char1) {
                    subChar = (char) (58 - char2 + char1);
                    carry--;
                }

                if (char1 > char2) {
                    subChar = (char) (char1 - char2 + 48);
                }

                if (char1 == char2) {
                    subChar = 48;
                }


                sub.number += subChar;


            }
        }

        sub.InvertString(sub);
        sub.RemoveZeros(sub);
        return sub;

    }

    // Multiplica
    BigNumber mult(BigNumber other) {
        int carry = 0;
        String results = "";

        if (this.number.charAt(0) == '0') {
            this.RemoveZeros(this);
        }

        if (other.number.charAt(0) == '0') {
            other.RemoveZeros(other);
        }

        String[] addResults = new String[other.number.length()];

        for (int i = other.number.length() - 1; i >= 0; i--) {
            char char1 = (char) (other.number.charAt(i) - 48);
            if (i < other.number.length() - 1) {
                for (int j = 0; j < other.number.length() - 1 - i; j++) {
                    results += 0;
                }
            }

            for (int j = this.number.length() - 1; j >= 0; j--) {
                char char2 = (char) (this.number.charAt(j) - 48);

                char adds = (char) (char2 * char1 + carry);
                carry = 0;

                while (adds >= 10) {
                    adds -= 10;
                    carry++;
                }

                results += (int) adds;
            }
            if (carry != 0) results += carry;

            addResults[i] = results;
            results = "";
            carry = 0;
        }

        for (int i = 0; i < addResults.length; i++) {
            String invert = "";
            for (int j = addResults[i].length() - 1; j >= 0; j--) {
                invert += addResults[i].charAt(j);
            }
            addResults[i] = invert;
        }

        if (addResults.length == 1) {
            BigNumber b1 = new BigNumber(addResults[0]);
            b1.RemoveZeros(b1);
            return b1;
        }

        if (addResults.length == 2) {
            BigNumber b1 = new BigNumber(addResults[0]);
            BigNumber b2 = new BigNumber(addResults[1]);
            BigNumber bResult = new BigNumber(b1.add(b2).number);
            bResult.RemoveZeros(b2);
            return bResult;
        }

        if (addResults.length > 2) {
            BigNumber b1 = new BigNumber(addResults[0]);
            BigNumber b2 = new BigNumber(addResults[1]);
            BigNumber addBigNumber = new BigNumber(b1.add(b2).number);

            for (int i = 2; i < addResults.length; i++) {
                addBigNumber.number = addBigNumber.add(new BigNumber(addResults[i])).number;
            }

            addBigNumber.RemoveZeros(addBigNumber);
            return addBigNumber;
        }
        return null;

    }

    // Divideix
    BigNumber div(BigNumber other) {
        BigNumber thisDiv = new BigNumber(this.number);
        BigNumber otherDiv = new BigNumber(other.number);
        BigNumber mult = new BigNumber("0");
        BigNumber add = new BigNumber("1");
        String quocient = "";

        if (other.compareTo(this) == 0) {
            mult.number = "1";

        } else {
            if (other.compareTo(this) == 1) {
                mult.number = "0";

            } else {
                while (other.compareTo(thisDiv) <= 0) {
                    thisDiv.number = "";

                    for (int i = 0; i < other.number.length(); i++) {
                        thisDiv.number += this.number.charAt(i);
                    }

                    if (other.compareTo(this) == 0) {
                        mult.number = "1";

                    } else {
                        if (other.compareTo(this) == 1) {
                            mult.number = "0";

                        } else {

                            if (thisDiv.compareTo(other) == -1) {
                                if (other.number.length() >= this.number.length()) {
                                    mult.number = "0";
                                    break;
                                }
                                thisDiv.number += this.number.charAt(other.number.length());
                            }
                        }
                    }

                    while (otherDiv.compareTo(thisDiv) <= 0) {
                        otherDiv = other.mult(mult);
                        mult = mult.add(add);
                    }

                    if (otherDiv.compareTo(thisDiv) >= 0) {
                        BigNumber sub = new BigNumber("2");
                        mult = mult.sub(sub);
                    }

                    otherDiv = otherDiv.sub(other);


                    otherDiv.InvertString(otherDiv);
                    otherDiv.AddZeros(this);
                    otherDiv.InvertString(otherDiv);

                    this.number = this.sub(otherDiv).number;
                    thisDiv.number = this.number;

                    quocient += mult.number;

                    if (thisDiv.number.equals("0")) quocient += 0;

                    mult.number = "1";
                    otherDiv = other;
                }
            }
        }

        mult.number = quocient;
        return mult;
    }


    // Arrel quadrada
    BigNumber sqrt() {
        return null;
    }

    // Potència
    BigNumber power(int n) {
        BigNumber power = new BigNumber("");

        if (this.number.charAt(0) == '0') this.RemoveZeros(this);

        if (n == 0) return new BigNumber("1");

        if (n == 1) return this;

        if (n == 2) {
            power = this.mult(this);
            System.out.println(power.number);
            return power;
        }

        if (n > 2) {
            power = this.mult(this);

            for (int i = 0; i < n - 2; i++) {
                power = power.mult(this);
            }
            return power;
        }

        return null;
    }


    // Factorial
    BigNumber factorial() {
        if (this.number.charAt(0) == '0') this.RemoveZeros(this);

        BigNumber factorial = new BigNumber(this.number);
        BigNumber sub = new BigNumber("1");
        BigNumber factorialAdd = new BigNumber("1");

        if (this.number.equals("0")) {
            return factorialAdd;
        } else {
            while (!factorial.number.equals("1")) {
                factorialAdd = factorialAdd.mult(factorial);
                factorial = factorial.sub(sub);
                System.out.println(factorialAdd.number);
            }
        }
        return factorialAdd;
    }


    // MCD. Torna el Màxim comú divisor
    BigNumber mcd(BigNumber other) {
        return null;
    }

    // Compara dos BigNumber. Torna 0 si són iguals, -1
// si el primer és menor i torna 1 si el segon és menor
    public int compareTo(BigNumber other) {
        int number = 2;
        if (this.number.charAt(0) == '0') {
            this.RemoveZeros(this);
        }
        if (other.number.charAt(0) == '0') {
            other.RemoveZeros(other);
        }

        if (this.number.charAt(0) == '0' && other.number.charAt(0) == '0') {
            number = 0;
        } else {
            if (this.number.charAt(0) == '0' && other.number.charAt(0) != '0') {
                number = -1;
            } else {
                if (this.number.charAt(0) != '0' && other.number.charAt(0) == '0') {
                    number = 1;
                } else {
                    if (this.number.equals(other.number)) number = 0;

                    if (this.number.length() > other.number.length()) number = 1;

                    if (this.number.length() < other.number.length()) number = -1;

                    if (this.number.length() == other.number.length()) {
                        for (int i = 0; i < this.number.length(); i++) {
                            if (this.number.charAt(i) > other.number.charAt(i)) {
                                number = 1;
                                break;
                            }

                            if (this.number.charAt(i) < other.number.charAt(i)) {
                                number = -1;
                                break;
                            }

                            if (this.number.charAt(i) == other.number.charAt(i)) {
                                if (i == this.number.length() - 1) i--;
                                i++;

                                if (this.number.charAt(i) > other.number.charAt(i)) {
                                    number = 1;
                                    break;
                                }

                                if (this.number.charAt(i) < other.number.charAt(i)) {
                                    number = -1;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        return number;
    }


    // Torna un String representant el número
    public String toString() {
        return this.number;
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
        for (int i = 0; i < b.number.length(); i++) {
            if (b.number.charAt(i) != '0') {
                for (int j = i; j < b.number.length(); j++) {
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
        for (int i = 0; i < diff; i++) {
            WithZeros.number += 0;
        }
        WithZeros.number += this.number;
        this.number = WithZeros.number;
    }

    public void InvertString(BigNumber b) {
        BigNumber Invert = new BigNumber("");
        for (int i = b.number.length() - 1; i >= 0; i--) {
            Invert.number += b.number.charAt(i);
        }
        b.number = Invert.number;
    }

}
