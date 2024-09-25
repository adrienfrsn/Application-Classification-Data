**Système** : Système de gestion de classification des données

**Cas d'utilisation** : Classifier la donnée non classifiée

**Acteur principal** : Utilisateur

**Déclencheur** : /

**Autres acteurs** : /

**Préconditions** :
    L'utilisateur a chargé un fichier CSV
    L'utilisateur a saisit un point

**Garanties en cas de succès** :
    On peut savoir a quoi correspond la donnée entrée selon le fichier CSV

**Garanties minimales** :
    Si la classification ne fonctionne pas, rien ne se passe

**Scénario nominal** :
    1. L'utilisateur selectionne la fonctionnalité "Classifier"
    2. Le système change la couleur du point qui était non classifié en fonction de sa catégorie.
    
**Scénarios alternatifs** :
    /