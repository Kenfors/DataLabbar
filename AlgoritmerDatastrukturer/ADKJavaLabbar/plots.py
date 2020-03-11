import matplotlib.pyplot as plt
import numpy as np
import fractions


# ADD 0?
x = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20]
y = [
    1,
    7,
    25,
    65,
    140,
    266,
    462,
    750,
    1155,
    1705,
    2431,
    3367,
    4550,
    6020,
    7820,
    9996,
    12597,
    15675,
    19285,
    23485
]


plt.title("Uppgift 1")
plt.ylabel("r - antal operationer")
plt.xlabel("n - iterationer")

"""
poly = np.polyfit(x,y,3)
poly_1d = np.poly1d(poly)
xaxis = np.linspace(x[0], x[-1], 50)
yaxis = poly_1d(xaxis)

equation  = str(fractions.Fraction(poly[0]).limit_denominator()) + "n^3 + "
equation += str(fractions.Fraction(poly[1]).limit_denominator()) + "n^2 + "
equation += str(fractions.Fraction(poly[2]).limit_denominator()) + "n + " 
equation += str(fractions.Fraction(poly[3]).limit_denominator())
plt.plot(xaxis, yaxis, label="T(" + equation + ")")
"""

poly = np.polyfit(x,y,4)
poly_1d = np.poly1d(poly)
xaxis = np.linspace(x[0], x[-1], 50)
yaxis = poly_1d(xaxis)

equation = str(fractions.Fraction(poly[0]).limit_denominator()) + "n^4 + "
equation += str(fractions.Fraction(poly[1]).limit_denominator()) + "n^3 + "
equation += str(fractions.Fraction(poly[2]).limit_denominator()) + "n^2 + "
equation += str(fractions.Fraction(poly[3]).limit_denominator()) + "n + " 
equation += str(fractions.Fraction(poly[4]).limit_denominator())
plt.plot(xaxis, yaxis, label="T(" + equation + ")")

plt.scatter(x,y, label="Orginal data", marker="x")

x = np.linspace(1, 20, 100)
plt.plot(x, 1/6*x**4, label="O(n^4)   c=1/6, n0 = 11  ")

plt.legend()
plt.grid(axis='both')
plt.show()
