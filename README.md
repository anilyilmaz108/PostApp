
# PostApp

PostApp is an application where users can see and share posts and comments after logging in, see to-do lists and mark their done, and profile information of users. The application allows users to follow their posts, share and monitor their own posts.

## Emulator Usage
![](https://github.com/anilyilmaz108/PostApp/blob/main/github_images/video.gif)

---

## Technologies

<div align="left">
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/kotlin/kotlin-original.svg" height="40" alt="kotlin logo"  />
</div>

---
- Clean Architecture
- MVVM architecture
- Navigation Component
- Retrofit
- Coroutines
- View Binding
- Shimmer Animation
- Dependency Injection - Hilt
---

## API Usage

### Fake Api Website URL
https://jsonplaceholder.typicode.com/


#### Fetch all posts

```http
  GET /posts
```

| Parameter | Type     | Description               |
| :-------- | :------- | :------------------------- |
|  | `string` | Return all posts |

#### Fetch todos by user id

```http
  GET /todos/${userId}
```

| Parameter | Type     | Description               |
| :-------- | :------- | :------------------------- |
| `userId`  | `int` | **Required**. ID of the item to be summoned |

#### Post item post

```http
  POST /posts
```

| Parameter | Type     | Description               |
| :-------- | :------- | :------------------------- |
| `title` `body` `userId`| `string` `string` `int` | create post |


#### Fetch all users

```http
  GET /user
```

| Parameter | Type     | Description               |
| :-------- | :------- | :------------------------- |
|  | `string` | Return all user |

#### Fetch all comments

```http
  GET /comments
```

| Parameter | Type     | Description               |
| :-------- | :------- | :------------------------- |
|  | `string` | Return all comments |




## Interfaces


| Login | Shimmer | Home | Comment | Share | Todo | Profile |
|:-----|:------:|-----:|:-----|:-----|:-----|:-----|
| <img src="https://github.com/anilyilmaz108/PostApp/blob/main/github_images/shimmer.png" height="250" width="150" />  | <img src="https://github.com/anilyilmaz108/PostApp/blob/main/github_images/login.png" height="250" width="150" /> | <img src="https://github.com/anilyilmaz108/PostApp/blob/main/github_images/home.png" height="250" width="150" /> | <img src="https://github.com/anilyilmaz108/PostApp/blob/main/github_images/comment.png" height="250" width="150" /> | <img src="https://github.com/anilyilmaz108/PostApp/blob/main/github_images/share.png" height="250" width="150" /> | <img src="https://github.com/anilyilmaz108/PostApp/blob/main/github_images/todo.png" height="250" width="150" /> | <img src="https://github.com/anilyilmaz108/PostApp/blob/main/github_images/profile.png" height="250" width="150" /> |

## Android App Bundle and APK 

Build -> Generate Signed Bundle / APK -> Next(choose anyone) -> Create new... -> OK (fill in the information) -> Next -> Finish (choose release) 

  
## Feedback

If you have any feedback, please contact us at anilyilmaz108@gmail.com.

  
## Technologies

<div align="left">
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/kotlin/kotlin-original.svg" height="40" alt="kotlin logo"  />
</div>

---
- Clean Architecture
- MVVM architecture
- Navigation Component
- Retrofit
- Coroutines
- View Binding
- Shimmer Animation
- Dependency Injection - Hilt
---


