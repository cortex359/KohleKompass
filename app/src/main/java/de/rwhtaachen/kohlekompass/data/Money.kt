package de.rwhtaachen.kohlekompass.data

import java.lang.NumberFormatException
import java.math.BigDecimal
import java.math.RoundingMode
import java.util.Currency
import java.util.Locale
import kotlin.math.pow

/* Example Usage:
    var a = Money(500, Currency.getInstance("JPY"))
    var b = Money(222)
    var c = Money(10000)
    println(a * 5) //-> 25,00 ¥
    println(b + c) //-> 102,22 €
    println(c / 1.19) //-> 84,03 €
 */
data class Money(
    var value: BigDecimal,
    var unit: Currency
) {
    /*
        > It is recommended to use BigDecimal class while dealing with Currency or monetary values
        > as it provides better handling of floating point numbers and their operations.
        @see: https://developer.android.com/reference/java/util/Currency
     */
    @JvmOverloads constructor(
        value: String, unit: Currency = Currency.getInstance(Locale.getDefault())
    ) : this(value
        .replace(Regex("[^[0-9]]*([0-9]+)[,.]?([0-9]+)?[^[0-9]]*"), "$1.$20")
        .toBigDecimal(),
        unit
    )

    @JvmOverloads constructor(
        value: Double, unit: Currency = Currency.getInstance(Locale.getDefault())
    ) : this(value.toBigDecimal(), unit)

    /**
     * Money(value: Int) expects value to be in the lowest non fractional unit of the currency, eg.
     * Cents, Penny's, Satoshi's, etc.
     */
    @JvmOverloads constructor(
        value: Int, unit: Currency = Currency.getInstance(Locale.getDefault())
    ) : this(
        value.toBigDecimal().divide(
            10.0.pow(
                Currency.getInstance(Locale.getDefault()).defaultFractionDigits
            ).toBigDecimal()
        ), unit
    )

    override fun toString(): String {
        return "%,.2f %s".format(Locale.getDefault(), this.value, this.unit.symbol)
    }

    operator fun plus(p: Money) : Money {
        if (unit == p.unit) {
            return Money(value + p.value, unit)
        } else {
            throw NumberFormatException("Currency conversion not implemented.")
        }
    }
    operator fun minus(p: Money) : Money {
        if (unit == p.unit) {
            return Money(value - p.value, unit)
        } else {
            throw NumberFormatException("Currency conversion not implemented.")
        }
    }

    operator fun times (f: BigDecimal) : Money {
        return Money(value * f, unit)
    }
    operator fun times (f: Int) : Money {
        return this * f.toBigDecimal()
    }
    operator fun times (f: Double) : Money {
        return this * f.toBigDecimal()
    }
    operator fun div (f: BigDecimal) : Money {
        return Money(value.divide(f, unit.defaultFractionDigits, RoundingMode.HALF_EVEN), unit)
    }
    operator fun div (f: Int) : Money {
        return this / f.toBigDecimal()
    }
    operator fun div (f: Double) : Money {
        return this / f.toBigDecimal()
    }
}