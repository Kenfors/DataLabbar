import matplotlib.pyplot as plt
import numpy as np


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
plt.ylabel("r")
plt.xlabel("n")


"""
poly = np.polyfit(x,y,2)
poly_1d = np.poly1d(poly)
xaxis = np.linspace(x[0], x[-1], 50)
yaxis = poly_1d(xaxis)

equation = str(round(poly[0], 2)) + "n^2 + " 
equation += str(round(poly[1],2)) + "n + " 
equation += str(round(poly[2], 2))
plt.plot(xaxis, yaxis, label="T(" + equation + ")")
"""
poly = np.polyfit(x,y,3)
poly_1d = np.poly1d(poly)
xaxis = np.linspace(x[0], x[-1], 50)
yaxis = poly_1d(xaxis)

equation = str(round(poly[0], 2)) + "n^3 + "
equation += str(round(poly[1], 2)) + "n^2 + " 
equation += str(round(poly[2], 2)) + "n + " 
equation += str(round(poly[3], 2))
plt.plot(xaxis, yaxis, label="T(" + equation + ")")

poly = np.polyfit(x,y,4)
poly_1d = np.poly1d(poly)
xaxis = np.linspace(x[0], x[-1], 50)
yaxis = poly_1d(xaxis)

equation = str(round(poly[0], 2)) + "n^4 + "
equation += str(round(poly[1], 2)) + "n^3 + "
equation += str(round(poly[2], 2)) + "n^2 + " 
equation += str(round(poly[3], 2)) + "n + " 
equation += str(round(poly[4], 2))
plt.plot(xaxis, yaxis, label="T(" + equation + ")")


poly = np.polyfit(x,y,5)
poly_1d = np.poly1d(poly)
xaxis = np.linspace(x[0], x[-1], 50)
yaxis = poly_1d(xaxis)
equation = str(round(poly[0], 2)) + "n^5 + "
equation += str(round(poly[1], 2)) + "n^4 + "
equation += str(round(poly[2], 2)) + "n^3 + "
equation += str(round(poly[3], 2)) + "n^2 + " 
equation += str(round(poly[4], 2)) + "n + " 
equation += str(round(poly[5], 2))
plt.plot(xaxis, yaxis, label="T(" + equation + ")")



plt.scatter(x,y, label="orginal", marker="x")

x = np.linspace(1, 20, 100)
plt.plot(x, 6*x**3, label="O(n^3), c=6, 2.5 < n0 < 2.7")

plt.legend()
plt.show()
