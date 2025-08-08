#!/usr/bin/env python3
"""
示例Web应用主程序
演示代码收集工具的使用效果
"""

from flask import Flask, render_template, request, jsonify
import json
import os
from datetime import datetime

app = Flask(__name__)

class DataManager:
    """数据管理类"""
    
    def __init__(self, data_file='data.json'):
        self.data_file = data_file
        self.data = self.load_data()
    
    def load_data(self):
        """加载数据文件"""
        if os.path.exists(self.data_file):
            with open(self.data_file, 'r', encoding='utf-8') as f:
                return json.load(f)
        return {'users': [], 'posts': []}
    
    def save_data(self):
        """保存数据到文件"""
        with open(self.data_file, 'w', encoding='utf-8') as f:
            json.dump(self.data, f, indent=2, ensure_ascii=False)
    
    def add_user(self, name, email):
        """添加用户"""
        user_id = len(self.data['users']) + 1
        user = {
            'id': user_id,
            'name': name,
            'email': email,
            'created_at': datetime.now().isoformat()
        }
        self.data['users'].append(user)
        self.save_data()
        return user
    
    def get_users(self):
        """获取所有用户"""
        return self.data['users']
    
    def add_post(self, title, content, author_id):
        """添加文章"""
        post_id = len(self.data['posts']) + 1
        post = {
            'id': post_id,
            'title': title,
            'content': content,
            'author_id': author_id,
            'created_at': datetime.now().isoformat()
        }
        self.data['posts'].append(post)
        self.save_data()
        return post

# 创建数据管理器实例
data_manager = DataManager()

@app.route('/')
def index():
    """首页"""
    users = data_manager.get_users()
    posts = data_manager.data['posts']
    return render_template('index.html', users=users, posts=posts)

@app.route('/api/users', methods=['GET', 'POST'])
def users_api():
    """用户API"""
    if request.method == 'POST':
        data = request.json
        user = data_manager.add_user(data['name'], data['email'])
        return jsonify({'success': True, 'user': user})
    else:
        users = data_manager.get_users()
        return jsonify({'users': users})

@app.route('/api/posts', methods=['GET', 'POST'])
def posts_api():
    """文章API"""
    if request.method == 'POST':
        data = request.json
        post = data_manager.add_post(
            data['title'], 
            data['content'], 
            data['author_id']
        )
        return jsonify({'success': True, 'post': post})
    else:
        posts = data_manager.data['posts']
        return jsonify({'posts': posts})

@app.route('/health')
def health_check():
    """健康检查接口"""
    return jsonify({
        'status': 'healthy',
        'timestamp': datetime.now().isoformat(),
        'version': '1.0.0'
    })

if __name__ == '__main__':
    app.run(debug=True, host='0.0.0.0', port=5000)