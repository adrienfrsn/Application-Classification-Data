**Système** : Système de gestion de classification des données

**Cas d'utilisation** : Ajouter un point avec ses données

**Acteur principal** : Utilisateur

**Déclencheur** : /

**Préconditions** : /

**Autres acteurs** : /

**Garanties en cas de succès** : Un point est apparu sur le graphique avec les bonnes coordonnées

**Garanties minimales** : Si les données sont mal ou pas rentrées le point ne se crée pas

**Scénario nominal** :

1. L'utilisateur selectionne la fonctionnalité "Ajouter un point"
2. Le système affiche un formulaire pour rentrer les données
3. L'utilisateur saisit les données du point et valide
4. Le système vérifie si les données sont correctement rentrées puis affiche le graphique avec le nouveau point bien visible

**Scénarios alternatifs** :
A. 4(A) Le système renvoie un message d'erreur si les données sont mal saisies
        (puis retour 3 scénario nominal)
