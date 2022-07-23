# Valorant

A sample android app consuming [Valorant API](https://valorant-api.com/) to display valorant agents, it has been built with **Jetpack Compose, Architecture Components** and **MVVM pattern**.

<p align="center">
  <img src="https://github.com/callebdev/Valorant/blob/develop/valorant/Screenshot_1658584586.png" width="300"><br>
</p>


The application architecture is split into 4 principal layers:
- Presentation
- Domain
- Data; and
- Common

For a [small project like this](https://twitter.com/CallebDev/status/1547886517644713984), this is a practical example of screaming architecture 😝.

<img width="258" alt="image" src="https://user-images.githubusercontent.com/42087219/180610587-cebedf6c-cf91-473c-8f41-79072ff372d8.png">


### Demo
https://user-images.githubusercontent.com/42087219/180609425-b4dcbf5a-f1ce-4545-b46b-934d7bf1c5cc.mp4

- For the horizontal infinite auto-scoll, I've used [Accompainist Pager](https://google.github.io/accompanist/pager/)
- I've used [Media Player](https://developer.android.com/reference/android/media/MediaPlayer) for playing agent's voices
- Retrofit for Network calls
- [Landscapist](https://github.com/skydoves/landscapist) for images loading

### In progress 🚧.
- [ ] Support different screen sizes
- [ ] Add retry option to error screens
- [ ] Write tests
- [ ] Code cleanup

### License
```
Copyright [yyyy] [name of copyright owner]

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
