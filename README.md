# javaChat
## Développement d'une application de chat avec sockets TCP

L’objectif du projet est de réaliser une application de chat centralisée basée sur les sockets
TCP. Dans cette application, vous devez créer une classe qui jouera le rôle du serveur. Le
serveur s’en charge de la création d’un point de connexion et recevra les demandes de
connexions des clients.

Pour chaque demande reçue, le serveur instanciera un socket de communication associé au
client venant de demander la connexion et le sauvegardera dans une liste. De plus, le serveur
instanciera un thread pour chaque client connecté. Ce thread interceptera les messages
envoyés par le client correspondant et les transfèrera aux autres clients, en utilisant les
sockets de communications sauvegardés dans la liste des clients lors de la phase de connexion.
De l’autre côté, le client doit tout d’abord établir une connexion avec le serveur à travers le
point de connexion créé auparavant. Dans le cas où la connexion est bien établie, le client
enverra son pseudo au serveur et accèdera au salon de discussion partagé entre l’ensemble
des clients qui sont connectés au serveur.

Par la suite, le client devra pouvoir envoyer des messages aux autres clients à travers le
serveur. De même, il est censé recevoir tous les messages envoyés (après sa connexion) par
les autres clients connectés au salon de discussion.

Si le client décide de quitter le salon, il enverra un message au serveur pour l’informer de sa
déconnexion. Dans ce cas, le serveur informera les autres clients de cette déconnexion.
Figure 1 décrit le fonctionnement général de l’application de chat.

![Figure 1: établissement de la connexion avec le serveur, et de la communication entre les clients](https://cdn.discordapp.com/attachments/850123545094782987/920310914186620938/unknown.png)
*Figure 1: établissement de la connexion avec le serveur, et de la communication entre les clients*

Dans ce projet, les utilisateurs de votre application de chat devront pouvoir communiquer à
travers une interface graphique permettant :
1. la saisie du pseudo de l’utilisateur et la connexion au salon de discussion.
2. la visualisation des messages envoyés dans le salon.
3. la saisie et l’envoi des messages aux autres utilisateurs.
