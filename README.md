# deezer

### Out of the test :
    - J'ai pris toutes les libs des projets ou j'ai pris un peu de code (sans faire de tri)
    - Il y a une variable COLUM_NUMBER dans build.gradle (app) pour choisir le nombre de row
    - Un build Mock avec un petit jeu de fake data (toute title = nekfeu)

<img src="DOC/deezer_gif.gif" width="300">


# Deezer Test Presentation

# BUILD SYSTEM:
    - Injection de dépendance au travers des build PROD // MOCK
        + PROD: utilise le serveur
        + MOCK: utilise des fake data pour lancer l'app sans internet

## Architecture entre le MVP // MVVM avec une pointe de MVI :

    - Un presenter pour choisir quel sub-view doit être appelé
    - Un ViewState (en guise de ViewModel)
    - Des ViewEvent, pour fire des UseCase (à la manière des Intent avec 
    les Action).
<img src="DOC/architecture.png" >

## Test.Strategie :
    - Des test Unitaire 
    - Des test de repository (avec et sans internet)
        + sans internet: test vraiment le repo
        + avec internet: test en plus les lib et le serveur
![](DOC/test.png?=400x200 )


## Scalable :
    - Multiplier les ViewState avec presenter et usecase associer.
    - Permet de recoder plusieurs fois de petit bout de code.
    - DUPLIQUER? JAMAIS ! Sauf qu'en se faisant, on rend le dev plus 
    intéressant et on évite d'avoir une équipe qui disparait tous les 
    6 mois. Car le projet n'est pas agréable à coder.
    - En plus ! Permet d'avoir un mode ESSAYER facilement.
    - Permet une meilleure agilité entre les divers composant, afin de build
    des version très différente :
        + (Asi / Europe).
        + Les pub interstitiel en Angletterre sont proscrite, alors qu'elles 
        fonctionnent bien en France.
<img src="DOC/compicados.png" >
<img src="DOC/complexity.png" >


## Pane :
    - Ce que j'appelle une pane est une View Custom qui regroupe l'ensemble des composant:
         - Event, UseCase, Presenter, viewController (dont les states, key_frame)
    - Un ViewController:
        - Composoant qui regroupe les 3 layout : enter, inside, exit
        - pour gérer les switch entre les view, grace au constraintSet
    - Chaque Etat doit avoir :
        - 3 layout : enter, inside, exit (pour assurer les transition de manière autonome)

| layout_enter                    | layout_inside                   | resultat                              | code                            |
| :---                            |     :---                        |                               :---:   |                            ---: |
| <img src="DOC/pane_key_0.png" > | <img src="DOC/pane_key_2.png" > | <img src="DOC/pane_transition.gif" >  | <img src="DOC/pane_code.png" >  |



ref : https://www.youtube.com/watch?v=OHcfs6rStRo
<img src="DOC/pane_.png" >
