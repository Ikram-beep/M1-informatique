import numpy as np
from sklearn import tree
from sklearn.tree import DecisionTreeRegressor
import matplotlib.pyplot as plt
 
# Création d'une base de données aléatoire
rng = np.random.RandomState(1)
X = np.sort(5 * rng.rand(80, 1), axis=0)
y = np.sin(X).ravel()
y[::5] += 3 * (0.5 - rng.rand(16))
 
# 2 modèles de régression avec des précisions différentes
regr_1 = DecisionTreeRegressor(max_depth=2)
regr_2 = DecisionTreeRegressor(max_depth=5)
regr_1.fit(X, y)
regr_2.fit(X, y)
 
# Prédictions
X_test = np.arange(0.0, 5.0, 0.01)[:, np.newaxis]
y_1 = regr_1.predict(X_test)
y_2 = regr_2.predict(X_test)
 
# Affichage des résultats
plt.figure()
plt.scatter(X, y, s=20, edgecolor="black",c="darkorange", label="données")
plt.plot(X_test, y_1, color="cornflowerblue",label="max_depth=2", linewidth=2)
plt.plot(X_test, y_2, color="yellowgreen", label="max_depth=5", linewidth=2)
plt.xlabel("donnée")
plt.ylabel("image (objectif)")
plt.title("Arbre de décision pour régression")
plt.legend()
plt.show()
tree.plot_tree(regr_1)


