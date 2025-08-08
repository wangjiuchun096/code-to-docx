# 示例项目

本目录包含了演示代码收集工具使用效果的示例项目。

## 项目结构

```
sample-project/
├── src/
│   ├── main.py          # Python Flask Web应用
│   └── config.js        # JavaScript前端配置
├── utils/
│   └── helpers.java     # Java工具类
└── config.json          # 示例配置文件
```

## 使用方法

### 1. 使用示例配置文件

```bash
# 进入项目根目录
cd code-to-docx

# 使用示例配置文件生成文档
python code-to-docx.py --config examples/sample-project/config.json
```

### 2. 直接命令行使用

```bash
python code-to-docx.py \
  --input ./examples/sample-project \
  --output ./examples/output \
  --filename "示例项目代码.docx" \
  --title "示例项目代码文档" \
  --max-pages 20
```

## 预期结果

运行后会在 `examples/output/` 目录下生成：
- `sample-project-code.docx` - 包含所有代码文件的Word文档

生成的文档包含：
1. 文档标题和基本信息
2. 文件目录索引
3. 每个源代码文件的完整内容（带行号）
4. 统一的格式和样式

## 文件类型

示例项目包含了多种常见的编程语言文件：
- **Python**: Flask Web应用，展示后端API开发
- **JavaScript**: 前端配置文件，展示配置管理
- **Java**: 工具类，展示企业级开发常用功能

这些文件展示了工具对不同编程语言的支持能力。