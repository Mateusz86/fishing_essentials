fishing_essentials
==================

fishes - ryby
-------------------------------------------------------------------------------------------------
id | name | type (“SP”/”D”) | description | food | tips | law | photos |



places - /6/ - £owiska
--------------------------------------------------------
id | name | description | latitude | longitude | date-time

fishing - /2/ - moje po³owy
---------------------------------------------
id | places_id | date-time | weather |

caught_fish - z³owione ryby
-------------------------------------------------------------------------------
id | fishing_id | fishes_id | fishLength | weight | bait_id | groundbait_id | methods_id | description | photo | date-time

bait - przynêta
----------------
id |  name | description

groundbait - zanety
--------------------
id |  name | description

methods - metody
-------------------
id |  name | description | zdjêcie

photos
--------------
id | name



fishes_photos
------------
id| fishes_id | photos_id

caught_fish_photos
------------
id| caught_fish_id | photos_id

methods_photos
------------
id| methods_id | photos_id