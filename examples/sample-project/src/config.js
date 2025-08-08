/**
 * 前端配置文件
 * 包含API端点、主题设置等配置项
 */

const CONFIG = {
    // API配置
    api: {
        baseUrl: 'http://localhost:5000',
        endpoints: {
            users: '/api/users',
            posts: '/api/posts',
            health: '/health'
        },
        timeout: 5000
    },
    
    // 主题配置
    theme: {
        primaryColor: '#3498db',
        secondaryColor: '#2ecc71',
        dangerColor: '#e74c3c',
        warningColor: '#f39c12',
        darkMode: false
    },
    
    // 分页配置
    pagination: {
        defaultPageSize: 10,
        maxPageSize: 100,
        showSizeChanger: true
    },
    
    // 表单验证配置
    validation: {
        email: {
            pattern: /^[^\s@]+@[^\s@]+\.[^\s@]+$/,
            message: '请输入有效的邮箱地址'
        },
        password: {
            minLength: 6,
            pattern: /^(?=.*[a-zA-Z])(?=.*\d)/,
            message: '密码至少6位，包含字母和数字'
        },
        username: {
            minLength: 2,
            maxLength: 20,
            pattern: /^[a-zA-Z0-9_\u4e00-\u9fa5]+$/,
            message: '用户名2-20位，支持中英文、数字、下划线'
        }
    },
    
    // 文件上传配置
    upload: {
        maxSize: 5 * 1024 * 1024, // 5MB
        allowedTypes: ['image/jpeg', 'image/png', 'image/gif'],
        endpoint: '/api/upload'
    },
    
    // 缓存配置
    cache: {
        enabled: true,
        ttl: 300000, // 5分钟
        maxSize: 100
    }
};

// 导出配置
if (typeof module !== 'undefined' && module.exports) {
    module.exports = CONFIG;
} else if (typeof window !== 'undefined') {
    window.CONFIG = CONFIG;
}