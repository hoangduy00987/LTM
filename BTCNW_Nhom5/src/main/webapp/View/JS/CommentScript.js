function addComment(user, content) {
    var commentList = document.getElementById('comment-list');

    // Create a new comment box
    var commentBox = document.createElement('div');
    commentBox.className = 'comment-box';
    commentBox.style.opacity = '0'; // Initial opacity for fadeIn effect

    // User name
    var userName = document.createElement('div');
    userName.className = 'user-name';
    userName.textContent = user + ": " || 'user: '; // Default to 'User' if user is not provided

    // Comment content container
    var commentContentContainer = document.createElement('div');
    commentContentContainer.className = 'comment-content-container';

    // Comment content
    var commentContent = document.createElement('div');
    commentContent.className = 'comment-content';
    commentContent.textContent = content;

    // Append user name and comment content to the comment content container
    commentContentContainer.appendChild(userName);
    commentContentContainer.appendChild(commentContent);

    // Append the new comment to the comment box
    commentBox.appendChild(commentContentContainer);

    // Append the comment-divider to create a line
    var commentDivider = document.createElement('div');
    commentDivider.className = 'comment-divider';
    commentBox.appendChild(commentDivider);

    // Append the new comment to the comment list
    commentList.appendChild(commentBox);

    // Apply fadeIn effect
    setTimeout(function () {
        commentBox.style.opacity = '1';
    }, 10);
}