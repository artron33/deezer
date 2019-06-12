# deezer



# Deezer Test Presentation

## Architecture entre le MVP // MVVM avec une pointe de MVI :

    - Un presenter pour choisir quel sub-view doit être appelé
    - Un ViewState (en guise de ViewModel)
    - Des ViewEvent, pour fire des UseCase (à la manière des Intent avec les Action).
    
![alt text](DOC/architecture.png?raw=true "Title")

