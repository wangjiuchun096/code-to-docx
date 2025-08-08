# 代码收集工具

![License](https://img.shields.io/badge/license-MIT-blue.svg)
![Python](https://img.shields.io/badge/python-3.7%2B-blue.svg)
![Tests](https://github.com/username/code-to-docx/workflows/Tests/badge.svg)

用于软著申请的代码收集工具，将指定目录下的代码文件合并到一个docx文档中。

## 快速开始

### 安装

```bash
# 克隆项目
git clone https://github.com/username/code-to-docx.git
cd code-to-docx

# 安装依赖
pip install -r requirements.txt
```

### 快速使用

```bash
# 生成配置文件
python code-to-docx.py --generate-config

# 编辑 config.json 配置文件，然后运行
python code-to-docx.py

# 或直接使用命令行参数
python code-to-docx.py --input ./src --output ./docs
```

## 功能特性

- ✅ 支持多种代码文件类型（Python, JavaScript, Java, C/C++, HTML, CSS等）
- ✅ 灵活的配置方式：命令行参数、配置文件、脚本内默认配置
- ✅ 配置优先级：命令行 > 配置文件 > 默认配置
- ✅ 文件大小限制，避免处理超大文件
- ✅ 智能文件过滤，排除构建产物和依赖目录
- ✅ 代码行号显示
- ✅ 完整的统计信息
- ✅ 友好的错误提示

## 安装依赖

```bash
pip install -r requirements.txt
```

## 使用方法

### 1. 使用配置文件（推荐）

```bash
# 生成示例配置文件
python code-to-docx.py --generate-config

# 编辑 config.json 文件，然后运行
python code-to-docx.py
```

### 2. 使用命令行参数

```bash
# 基本用法
python code-to-docx.py --input ./src --output ./docs

# 完整参数
python code-to-docx.py --input ./src --output ./docs --filename myproject.docx --title "我的项目代码"
```

### 3. 混合使用

```bash
# 使用自定义配置文件
python code-to-docx.py --config my-config.json

# 配置文件 + 命令行参数覆盖
python code-to-docx.py --input /custom/path --output /custom/output
```

## 配置参数说明

| 参数 | 类型 | 说明 | 默认值 |
|------|------|------|--------|
| input_dir | string | 输入目录路径 | "./src" |
| output_dir | string | 输出目录路径 | "./output" |
| filename | string | 输出文件名 | "project-code.docx" |
| file_extensions | array | 支持的文件扩展名 | [".py", ".js", ".java", ...] |
| exclude_dirs | array | 排除的目录 | ["node_modules", ".git", ...] |
| exclude_files | array | 排除的文件模式 | ["*.min.js", "*.min.css", ...] |
| max_file_size | string | 最大文件大小限制 | "1MB" |
| max_pages | integer | 最大页数限制 | 0 (0表示不限制) |
| add_line_numbers | boolean | 是否添加行号 | true |
| document_title | string | 文档标题 | "项目代码文档" |

## 支持的文件类型

- **编程语言**: .py, .js, .java, .cpp, .c, .h, .go, .rs, .rb, .swift, .kt, .cs, .php
- **前端**: .html, .css, .ts, .jsx, .tsx, .vue
- **配置文件**: .json, .yaml, .yml, .xml
- **文档**: .md, .txt, .sql

## 输出格式

生成的docx文档包含：
1. 文档标题和基本信息
2. 文件目录索引
3. 每个文件的完整代码内容（带行号）
4. 统一的格式和样式

## 示例

```bash
# 处理当前项目的src目录
python code-to-docx.py --input ./src --output ./docs --filename "项目源码.docx"

# 只处理Python和JavaScript文件
python code-to-docx.py --input ./src --extensions ".py,.js" --max-size "2MB"

# 限制文档最大页数（适用于软著申请页数要求）
python code-to-docx.py --input ./src --max-pages 60

# 使用自定义标题
python code-to-docx.py --input ./src --title "软著申请代码文档"
```

## 注意事项

1. 确保有足够的磁盘空间存储生成的docx文件
2. 大型项目建议设置合理的文件大小限制
3. 软著申请通常有页数要求，建议使用 `max_pages` 参数控制文档页数
4. 页数估算基于每页约50行代码，实际页数可能有差异
5. 生成的文档可能较大，请耐心等待处理完成
6. 建议在处理前检查输入目录是否正确

## 贡献

欢迎提交 Issue 和 Pull Request！

1. Fork 本项目
2. 创建特性分支 (`git checkout -b feature/amazing-feature`)
3. 提交更改 (`git commit -m 'Add amazing feature'`)
4. 推送到分支 (`git push origin feature/amazing-feature`)
5. 开启 Pull Request

## 许可证

本项目采用 MIT 许可证。详情请参阅 [LICENSE](LICENSE) 文件。

## 致谢

- [python-docx](https://python-docx.readthedocs.io/) - 用于生成 Word 文档
- 所有贡献者和使用者的支持