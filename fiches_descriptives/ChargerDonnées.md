**Système** : Système de gestion de classification des données

**Cas d'utilisation** : Charger l'ensemble de données

**Acteur principal** : Utilisateur

**Déclencheur** : /

**Autres acteurs** : /

**Préconditions** :
    /

**Garanties en cas de succès** :
    On peut voir le nuage de points des données qui ont été chargées

**Garanties minimales** :
    Si le chargement échoue, il ne se passe rien

**Scénario nominal** :

1. L'utilisateur selectionne la fonctionnalité "Charger des données"
2. Le système affiche un explorateur de fichier pour selectionner le fichier.
3. L'utilisateur selectionne le fichier qu'il souhaite charger.
4. Le système s'occupe de charger le fichier et choisit des axes par défaut et affiche le nuage de points.

**Scénarios alternatifs** :
    Etape 4 : Si le fichier CSV est incorrect, le système propose de selectionner un autre fichier
    Retour à l'étape 2