# Example to search & replace in VSCode with RegEx (Regular Expression)

I want to replace the following in my readme.md

```text
1. ** to ## Step 1
2. ** to ## Step 2
3. ** to ## Step 3
...
```

- I press Ctrl + H
- then in the Search field, use `\*\*(.*?)\*\*`
- then in the replace field, use `## Step $1`

![1698538687995](image/VSCodeReplaceRegExpress/1698538687995.png)
