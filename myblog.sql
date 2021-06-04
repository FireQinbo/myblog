/*
 Navicat Premium Data Transfer

 Source Server         : 个人云主机(优刻得)
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : 113.31.124.33:3306
 Source Schema         : myblog

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 04/06/2021 16:13:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for mb_article
-- ----------------------------
DROP TABLE IF EXISTS `mb_article`;
CREATE TABLE `mb_article`  (
  `id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文章标题',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '文章内容',
  `title_img` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题图片',
  `click_num` int(0) NULL DEFAULT NULL COMMENT '点击数量',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '文章表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of mb_article
-- ----------------------------
INSERT INTO `mb_article` VALUES ('1', '测试标题1', '<p>本项目纯开源免费, 商品信息均来自网络,如有侵权,请联系作者,我会及时删除!</p>\r\n</blockquote>\r\n<p>前一段,看到一个大佬写的叮咚买菜,挺好,于是乎自己在家也琢磨了一下,自己搞了一版本,记录一些uni-app的开发事项,纯属个人总结,不对之处,还请指教!功能不是很全面,以后决定作为一个系列,持续更新</p>\r\n<h2 data-id=\"heading-0\">一.预览:</h2>\r\n<p>在线预览地址: <a target=\"_blank\" href=\"http://dingdong.nodebook.top/\">dingdong.nodebook.top/</a></p>\r\n<p>GitHub: <a target=\"_blank\" href=\"https://github.com/cgq001/dingdong\">github.com/cgq001/ding…</a></p>\r\n<p>管理后台: <a target=\"_blank\" href=\"http://dingdong-admin.nodebook.top/\">dingdong-admin.nodebook.top/</a></p>\r\n<p>如果你觉得还凑合,给个start怎么样? 我会继续努力完善项目,争取做到前后台完整开源</p>\r\n<h4 data-id=\"heading-1\">1.首页</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170ccefad77bb8b3?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h4 data-id=\"heading-2\">2.分类</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170cceffd61b878c?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h4 data-id=\"heading-3\">3.加入购物车</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170ccf00f900d318?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h4 data-id=\"heading-4\">4.收货地址</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170ccf01837d3a4c?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h4 data-id=\"heading-5\">5.我的</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170ccf021f2413e6?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h2 data-id=\"heading-6\">二.项目简介</h2>\r\n<h3 data-id=\"heading-7\">1.vant Ui库</h3>\r\n<p>在uni-app中使用H5版Ui库\r\n本站采用vant的H5版本(打包小程序和APP请使用vant的小程序版)UI库</p>\r\n<pre><code lang=\"bash\" class=\"copyable\">npm init <span># 初始化package.json文件</span>\r\nnpm i vant -S <span># 通过npm安装vant的H5版本</span>\r\n<span class=\"copy-code-btn\">复制代码</span></code></pre><p>vant H5版本的使用(全局引入)</p>\r\n<p>main.js</p>', 'https://scpic.chinaz.net/files/pic/pic9/202105/bpic23242.jpg', 12, '2021-06-01 18:31:04', NULL, NULL, NULL);
INSERT INTO `mb_article` VALUES ('10', '测试标题2', '<p>本项目纯开源免费, 商品信息均来自网络,如有侵权,请联系作者,我会及时删除!</p>\r\n</blockquote>\r\n<p>前一段,看到一个大佬写的叮咚买菜,挺好,于是乎自己在家也琢磨了一下,自己搞了一版本,记录一些uni-app的开发事项,纯属个人总结,不对之处,还请指教!功能不是很全面,以后决定作为一个系列,持续更新</p>\r\n<h2 data-id=\"heading-0\">一.预览:</h2>\r\n<p>在线预览地址: <a target=\"_blank\" href=\"http://dingdong.nodebook.top/\">dingdong.nodebook.top/</a></p>\r\n<p>GitHub: <a target=\"_blank\" href=\"https://github.com/cgq001/dingdong\">github.com/cgq001/ding…</a></p>\r\n<p>管理后台: <a target=\"_blank\" href=\"http://dingdong-admin.nodebook.top/\">dingdong-admin.nodebook.top/</a></p>\r\n<p>如果你觉得还凑合,给个start怎么样? 我会继续努力完善项目,争取做到前后台完整开源</p>\r\n<h4 data-id=\"heading-1\">1.首页</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170ccefad77bb8b3?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h4 data-id=\"heading-2\">2.分类</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170cceffd61b878c?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h4 data-id=\"heading-3\">3.加入购物车</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170ccf00f900d318?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h4 data-id=\"heading-4\">4.收货地址</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170ccf01837d3a4c?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h4 data-id=\"heading-5\">5.我的</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170ccf021f2413e6?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h2 data-id=\"heading-6\">二.项目简介</h2>\r\n<h3 data-id=\"heading-7\">1.vant Ui库</h3>\r\n<p>在uni-app中使用H5版Ui库\r\n本站采用vant的H5版本(打包小程序和APP请使用vant的小程序版)UI库</p>\r\n<pre><code lang=\"bash\" class=\"copyable\">npm init <span># 初始化package.json文件</span>\r\nnpm i vant -S <span># 通过npm安装vant的H5版本</span>\r\n<span class=\"copy-code-btn\">复制代码</span></code></pre><p>vant H5版本的使用(全局引入)</p>\r\n<p>main.js</p>', 'https://scpic.chinaz.net/files/pic/pic9/202104/bpic23077.jpg', 55, '2021-06-02 18:31:04', NULL, NULL, NULL);
INSERT INTO `mb_article` VALUES ('11', '测试标题2', '<p>本项目纯开源免费, 商品信息均来自网络,如有侵权,请联系作者,我会及时删除!</p>\r\n</blockquote>\r\n<p>前一段,看到一个大佬写的叮咚买菜,挺好,于是乎自己在家也琢磨了一下,自己搞了一版本,记录一些uni-app的开发事项,纯属个人总结,不对之处,还请指教!功能不是很全面,以后决定作为一个系列,持续更新</p>\r\n<h2 data-id=\"heading-0\">一.预览:</h2>\r\n<p>在线预览地址: <a target=\"_blank\" href=\"http://dingdong.nodebook.top/\">dingdong.nodebook.top/</a></p>\r\n<p>GitHub: <a target=\"_blank\" href=\"https://github.com/cgq001/dingdong\">github.com/cgq001/ding…</a></p>\r\n<p>管理后台: <a target=\"_blank\" href=\"http://dingdong-admin.nodebook.top/\">dingdong-admin.nodebook.top/</a></p>\r\n<p>如果你觉得还凑合,给个start怎么样? 我会继续努力完善项目,争取做到前后台完整开源</p>\r\n<h4 data-id=\"heading-1\">1.首页</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170ccefad77bb8b3?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h4 data-id=\"heading-2\">2.分类</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170cceffd61b878c?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h4 data-id=\"heading-3\">3.加入购物车</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170ccf00f900d318?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h4 data-id=\"heading-4\">4.收货地址</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170ccf01837d3a4c?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h4 data-id=\"heading-5\">5.我的</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170ccf021f2413e6?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h2 data-id=\"heading-6\">二.项目简介</h2>\r\n<h3 data-id=\"heading-7\">1.vant Ui库</h3>\r\n<p>在uni-app中使用H5版Ui库\r\n本站采用vant的H5版本(打包小程序和APP请使用vant的小程序版)UI库</p>\r\n<pre><code lang=\"bash\" class=\"copyable\">npm init <span># 初始化package.json文件</span>\r\nnpm i vant -S <span># 通过npm安装vant的H5版本</span>\r\n<span class=\"copy-code-btn\">复制代码</span></code></pre><p>vant H5版本的使用(全局引入)</p>\r\n<p>main.js</p>', 'https://scpic.chinaz.net/files/pic/pic9/202104/bpic23077.jpg', 55, '2021-06-02 18:31:04', NULL, NULL, NULL);
INSERT INTO `mb_article` VALUES ('12', '测试标题2', '<p>本项目纯开源免费, 商品信息均来自网络,如有侵权,请联系作者,我会及时删除!</p>\r\n</blockquote>\r\n<p>前一段,看到一个大佬写的叮咚买菜,挺好,于是乎自己在家也琢磨了一下,自己搞了一版本,记录一些uni-app的开发事项,纯属个人总结,不对之处,还请指教!功能不是很全面,以后决定作为一个系列,持续更新</p>\r\n<h2 data-id=\"heading-0\">一.预览:</h2>\r\n<p>在线预览地址: <a target=\"_blank\" href=\"http://dingdong.nodebook.top/\">dingdong.nodebook.top/</a></p>\r\n<p>GitHub: <a target=\"_blank\" href=\"https://github.com/cgq001/dingdong\">github.com/cgq001/ding…</a></p>\r\n<p>管理后台: <a target=\"_blank\" href=\"http://dingdong-admin.nodebook.top/\">dingdong-admin.nodebook.top/</a></p>\r\n<p>如果你觉得还凑合,给个start怎么样? 我会继续努力完善项目,争取做到前后台完整开源</p>\r\n<h4 data-id=\"heading-1\">1.首页</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170ccefad77bb8b3?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h4 data-id=\"heading-2\">2.分类</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170cceffd61b878c?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h4 data-id=\"heading-3\">3.加入购物车</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170ccf00f900d318?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h4 data-id=\"heading-4\">4.收货地址</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170ccf01837d3a4c?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h4 data-id=\"heading-5\">5.我的</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170ccf021f2413e6?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h2 data-id=\"heading-6\">二.项目简介</h2>\r\n<h3 data-id=\"heading-7\">1.vant Ui库</h3>\r\n<p>在uni-app中使用H5版Ui库\r\n本站采用vant的H5版本(打包小程序和APP请使用vant的小程序版)UI库</p>\r\n<pre><code lang=\"bash\" class=\"copyable\">npm init <span># 初始化package.json文件</span>\r\nnpm i vant -S <span># 通过npm安装vant的H5版本</span>\r\n<span class=\"copy-code-btn\">复制代码</span></code></pre><p>vant H5版本的使用(全局引入)</p>\r\n<p>main.js</p>', 'https://scpic.chinaz.net/files/pic/pic9/202104/bpic23077.jpg', 55, '2021-06-02 18:31:04', NULL, NULL, NULL);
INSERT INTO `mb_article` VALUES ('13', '测试标题2', '<p>本项目纯开源免费, 商品信息均来自网络,如有侵权,请联系作者,我会及时删除!</p>\r\n</blockquote>\r\n<p>前一段,看到一个大佬写的叮咚买菜,挺好,于是乎自己在家也琢磨了一下,自己搞了一版本,记录一些uni-app的开发事项,纯属个人总结,不对之处,还请指教!功能不是很全面,以后决定作为一个系列,持续更新</p>\r\n<h2 data-id=\"heading-0\">一.预览:</h2>\r\n<p>在线预览地址: <a target=\"_blank\" href=\"http://dingdong.nodebook.top/\">dingdong.nodebook.top/</a></p>\r\n<p>GitHub: <a target=\"_blank\" href=\"https://github.com/cgq001/dingdong\">github.com/cgq001/ding…</a></p>\r\n<p>管理后台: <a target=\"_blank\" href=\"http://dingdong-admin.nodebook.top/\">dingdong-admin.nodebook.top/</a></p>\r\n<p>如果你觉得还凑合,给个start怎么样? 我会继续努力完善项目,争取做到前后台完整开源</p>\r\n<h4 data-id=\"heading-1\">1.首页</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170ccefad77bb8b3?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h4 data-id=\"heading-2\">2.分类</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170cceffd61b878c?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h4 data-id=\"heading-3\">3.加入购物车</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170ccf00f900d318?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h4 data-id=\"heading-4\">4.收货地址</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170ccf01837d3a4c?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h4 data-id=\"heading-5\">5.我的</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170ccf021f2413e6?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h2 data-id=\"heading-6\">二.项目简介</h2>\r\n<h3 data-id=\"heading-7\">1.vant Ui库</h3>\r\n<p>在uni-app中使用H5版Ui库\r\n本站采用vant的H5版本(打包小程序和APP请使用vant的小程序版)UI库</p>\r\n<pre><code lang=\"bash\" class=\"copyable\">npm init <span># 初始化package.json文件</span>\r\nnpm i vant -S <span># 通过npm安装vant的H5版本</span>\r\n<span class=\"copy-code-btn\">复制代码</span></code></pre><p>vant H5版本的使用(全局引入)</p>\r\n<p>main.js</p>', 'https://scpic.chinaz.net/files/pic/pic9/202104/bpic23077.jpg', 55, '2021-06-02 18:31:04', NULL, NULL, NULL);
INSERT INTO `mb_article` VALUES ('2', '测试标题2', '<p>本项目纯开源免费, 商品信息均来自网络,如有侵权,请联系作者,我会及时删除!</p>\r\n</blockquote>\r\n<p>前一段,看到一个大佬写的叮咚买菜,挺好,于是乎自己在家也琢磨了一下,自己搞了一版本,记录一些uni-app的开发事项,纯属个人总结,不对之处,还请指教!功能不是很全面,以后决定作为一个系列,持续更新</p>\r\n<h2 data-id=\"heading-0\">一.预览:</h2>\r\n<p>在线预览地址: <a target=\"_blank\" href=\"http://dingdong.nodebook.top/\">dingdong.nodebook.top/</a></p>\r\n<p>GitHub: <a target=\"_blank\" href=\"https://github.com/cgq001/dingdong\">github.com/cgq001/ding…</a></p>\r\n<p>管理后台: <a target=\"_blank\" href=\"http://dingdong-admin.nodebook.top/\">dingdong-admin.nodebook.top/</a></p>\r\n<p>如果你觉得还凑合,给个start怎么样? 我会继续努力完善项目,争取做到前后台完整开源</p>\r\n<h4 data-id=\"heading-1\">1.首页</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170ccefad77bb8b3?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h4 data-id=\"heading-2\">2.分类</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170cceffd61b878c?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h4 data-id=\"heading-3\">3.加入购物车</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170ccf00f900d318?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h4 data-id=\"heading-4\">4.收货地址</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170ccf01837d3a4c?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h4 data-id=\"heading-5\">5.我的</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170ccf021f2413e6?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h2 data-id=\"heading-6\">二.项目简介</h2>\r\n<h3 data-id=\"heading-7\">1.vant Ui库</h3>\r\n<p>在uni-app中使用H5版Ui库\r\n本站采用vant的H5版本(打包小程序和APP请使用vant的小程序版)UI库</p>\r\n<pre><code lang=\"bash\" class=\"copyable\">npm init <span># 初始化package.json文件</span>\r\nnpm i vant -S <span># 通过npm安装vant的H5版本</span>\r\n<span class=\"copy-code-btn\">复制代码</span></code></pre><p>vant H5版本的使用(全局引入)</p>\r\n<p>main.js</p>', 'https://scpic.chinaz.net/files/pic/pic9/202104/bpic23077.jpg', 55, '2021-06-02 18:31:04', NULL, NULL, NULL);
INSERT INTO `mb_article` VALUES ('3', '测试标题2', '<p>本项目纯开源免费, 商品信息均来自网络,如有侵权,请联系作者,我会及时删除!</p>\r\n</blockquote>\r\n<p>前一段,看到一个大佬写的叮咚买菜,挺好,于是乎自己在家也琢磨了一下,自己搞了一版本,记录一些uni-app的开发事项,纯属个人总结,不对之处,还请指教!功能不是很全面,以后决定作为一个系列,持续更新</p>\r\n<h2 data-id=\"heading-0\">一.预览:</h2>\r\n<p>在线预览地址: <a target=\"_blank\" href=\"http://dingdong.nodebook.top/\">dingdong.nodebook.top/</a></p>\r\n<p>GitHub: <a target=\"_blank\" href=\"https://github.com/cgq001/dingdong\">github.com/cgq001/ding…</a></p>\r\n<p>管理后台: <a target=\"_blank\" href=\"http://dingdong-admin.nodebook.top/\">dingdong-admin.nodebook.top/</a></p>\r\n<p>如果你觉得还凑合,给个start怎么样? 我会继续努力完善项目,争取做到前后台完整开源</p>\r\n<h4 data-id=\"heading-1\">1.首页</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170ccefad77bb8b3?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h4 data-id=\"heading-2\">2.分类</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170cceffd61b878c?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h4 data-id=\"heading-3\">3.加入购物车</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170ccf00f900d318?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h4 data-id=\"heading-4\">4.收货地址</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170ccf01837d3a4c?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h4 data-id=\"heading-5\">5.我的</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170ccf021f2413e6?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h2 data-id=\"heading-6\">二.项目简介</h2>\r\n<h3 data-id=\"heading-7\">1.vant Ui库</h3>\r\n<p>在uni-app中使用H5版Ui库\r\n本站采用vant的H5版本(打包小程序和APP请使用vant的小程序版)UI库</p>\r\n<pre><code lang=\"bash\" class=\"copyable\">npm init <span># 初始化package.json文件</span>\r\nnpm i vant -S <span># 通过npm安装vant的H5版本</span>\r\n<span class=\"copy-code-btn\">复制代码</span></code></pre><p>vant H5版本的使用(全局引入)</p>\r\n<p>main.js</p>', 'https://scpic.chinaz.net/files/pic/pic9/202104/bpic23077.jpg', 55, '2021-06-02 18:31:04', NULL, NULL, NULL);
INSERT INTO `mb_article` VALUES ('4', '测试标题2', '<p>本项目纯开源免费, 商品信息均来自网络,如有侵权,请联系作者,我会及时删除!</p>\r\n</blockquote>\r\n<p>前一段,看到一个大佬写的叮咚买菜,挺好,于是乎自己在家也琢磨了一下,自己搞了一版本,记录一些uni-app的开发事项,纯属个人总结,不对之处,还请指教!功能不是很全面,以后决定作为一个系列,持续更新</p>\r\n<h2 data-id=\"heading-0\">一.预览:</h2>\r\n<p>在线预览地址: <a target=\"_blank\" href=\"http://dingdong.nodebook.top/\">dingdong.nodebook.top/</a></p>\r\n<p>GitHub: <a target=\"_blank\" href=\"https://github.com/cgq001/dingdong\">github.com/cgq001/ding…</a></p>\r\n<p>管理后台: <a target=\"_blank\" href=\"http://dingdong-admin.nodebook.top/\">dingdong-admin.nodebook.top/</a></p>\r\n<p>如果你觉得还凑合,给个start怎么样? 我会继续努力完善项目,争取做到前后台完整开源</p>\r\n<h4 data-id=\"heading-1\">1.首页</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170ccefad77bb8b3?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h4 data-id=\"heading-2\">2.分类</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170cceffd61b878c?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h4 data-id=\"heading-3\">3.加入购物车</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170ccf00f900d318?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h4 data-id=\"heading-4\">4.收货地址</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170ccf01837d3a4c?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h4 data-id=\"heading-5\">5.我的</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170ccf021f2413e6?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h2 data-id=\"heading-6\">二.项目简介</h2>\r\n<h3 data-id=\"heading-7\">1.vant Ui库</h3>\r\n<p>在uni-app中使用H5版Ui库\r\n本站采用vant的H5版本(打包小程序和APP请使用vant的小程序版)UI库</p>\r\n<pre><code lang=\"bash\" class=\"copyable\">npm init <span># 初始化package.json文件</span>\r\nnpm i vant -S <span># 通过npm安装vant的H5版本</span>\r\n<span class=\"copy-code-btn\">复制代码</span></code></pre><p>vant H5版本的使用(全局引入)</p>\r\n<p>main.js</p>', 'https://scpic.chinaz.net/files/pic/pic9/202104/bpic23077.jpg', 55, '2021-06-02 18:31:04', NULL, NULL, NULL);
INSERT INTO `mb_article` VALUES ('5', '测试标题2', '<p>本项目纯开源免费, 商品信息均来自网络,如有侵权,请联系作者,我会及时删除!</p>\r\n</blockquote>\r\n<p>前一段,看到一个大佬写的叮咚买菜,挺好,于是乎自己在家也琢磨了一下,自己搞了一版本,记录一些uni-app的开发事项,纯属个人总结,不对之处,还请指教!功能不是很全面,以后决定作为一个系列,持续更新</p>\r\n<h2 data-id=\"heading-0\">一.预览:</h2>\r\n<p>在线预览地址: <a target=\"_blank\" href=\"http://dingdong.nodebook.top/\">dingdong.nodebook.top/</a></p>\r\n<p>GitHub: <a target=\"_blank\" href=\"https://github.com/cgq001/dingdong\">github.com/cgq001/ding…</a></p>\r\n<p>管理后台: <a target=\"_blank\" href=\"http://dingdong-admin.nodebook.top/\">dingdong-admin.nodebook.top/</a></p>\r\n<p>如果你觉得还凑合,给个start怎么样? 我会继续努力完善项目,争取做到前后台完整开源</p>\r\n<h4 data-id=\"heading-1\">1.首页</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170ccefad77bb8b3?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h4 data-id=\"heading-2\">2.分类</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170cceffd61b878c?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h4 data-id=\"heading-3\">3.加入购物车</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170ccf00f900d318?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h4 data-id=\"heading-4\">4.收货地址</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170ccf01837d3a4c?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h4 data-id=\"heading-5\">5.我的</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170ccf021f2413e6?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h2 data-id=\"heading-6\">二.项目简介</h2>\r\n<h3 data-id=\"heading-7\">1.vant Ui库</h3>\r\n<p>在uni-app中使用H5版Ui库\r\n本站采用vant的H5版本(打包小程序和APP请使用vant的小程序版)UI库</p>\r\n<pre><code lang=\"bash\" class=\"copyable\">npm init <span># 初始化package.json文件</span>\r\nnpm i vant -S <span># 通过npm安装vant的H5版本</span>\r\n<span class=\"copy-code-btn\">复制代码</span></code></pre><p>vant H5版本的使用(全局引入)</p>\r\n<p>main.js</p>', 'https://scpic.chinaz.net/files/pic/pic9/202104/bpic23077.jpg', 55, '2021-06-02 18:31:04', NULL, NULL, NULL);
INSERT INTO `mb_article` VALUES ('6', '测试标题2', '<p>本项目纯开源免费, 商品信息均来自网络,如有侵权,请联系作者,我会及时删除!</p>\r\n</blockquote>\r\n<p>前一段,看到一个大佬写的叮咚买菜,挺好,于是乎自己在家也琢磨了一下,自己搞了一版本,记录一些uni-app的开发事项,纯属个人总结,不对之处,还请指教!功能不是很全面,以后决定作为一个系列,持续更新</p>\r\n<h2 data-id=\"heading-0\">一.预览:</h2>\r\n<p>在线预览地址: <a target=\"_blank\" href=\"http://dingdong.nodebook.top/\">dingdong.nodebook.top/</a></p>\r\n<p>GitHub: <a target=\"_blank\" href=\"https://github.com/cgq001/dingdong\">github.com/cgq001/ding…</a></p>\r\n<p>管理后台: <a target=\"_blank\" href=\"http://dingdong-admin.nodebook.top/\">dingdong-admin.nodebook.top/</a></p>\r\n<p>如果你觉得还凑合,给个start怎么样? 我会继续努力完善项目,争取做到前后台完整开源</p>\r\n<h4 data-id=\"heading-1\">1.首页</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170ccefad77bb8b3?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h4 data-id=\"heading-2\">2.分类</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170cceffd61b878c?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h4 data-id=\"heading-3\">3.加入购物车</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170ccf00f900d318?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h4 data-id=\"heading-4\">4.收货地址</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170ccf01837d3a4c?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h4 data-id=\"heading-5\">5.我的</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170ccf021f2413e6?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h2 data-id=\"heading-6\">二.项目简介</h2>\r\n<h3 data-id=\"heading-7\">1.vant Ui库</h3>\r\n<p>在uni-app中使用H5版Ui库\r\n本站采用vant的H5版本(打包小程序和APP请使用vant的小程序版)UI库</p>\r\n<pre><code lang=\"bash\" class=\"copyable\">npm init <span># 初始化package.json文件</span>\r\nnpm i vant -S <span># 通过npm安装vant的H5版本</span>\r\n<span class=\"copy-code-btn\">复制代码</span></code></pre><p>vant H5版本的使用(全局引入)</p>\r\n<p>main.js</p>', 'https://scpic.chinaz.net/files/pic/pic9/202104/bpic23077.jpg', 55, '2021-06-02 18:31:04', NULL, NULL, NULL);
INSERT INTO `mb_article` VALUES ('7', '测试标题2', '<p>本项目纯开源免费, 商品信息均来自网络,如有侵权,请联系作者,我会及时删除!</p>\r\n</blockquote>\r\n<p>前一段,看到一个大佬写的叮咚买菜,挺好,于是乎自己在家也琢磨了一下,自己搞了一版本,记录一些uni-app的开发事项,纯属个人总结,不对之处,还请指教!功能不是很全面,以后决定作为一个系列,持续更新</p>\r\n<h2 data-id=\"heading-0\">一.预览:</h2>\r\n<p>在线预览地址: <a target=\"_blank\" href=\"http://dingdong.nodebook.top/\">dingdong.nodebook.top/</a></p>\r\n<p>GitHub: <a target=\"_blank\" href=\"https://github.com/cgq001/dingdong\">github.com/cgq001/ding…</a></p>\r\n<p>管理后台: <a target=\"_blank\" href=\"http://dingdong-admin.nodebook.top/\">dingdong-admin.nodebook.top/</a></p>\r\n<p>如果你觉得还凑合,给个start怎么样? 我会继续努力完善项目,争取做到前后台完整开源</p>\r\n<h4 data-id=\"heading-1\">1.首页</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170ccefad77bb8b3?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h4 data-id=\"heading-2\">2.分类</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170cceffd61b878c?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h4 data-id=\"heading-3\">3.加入购物车</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170ccf00f900d318?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h4 data-id=\"heading-4\">4.收货地址</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170ccf01837d3a4c?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h4 data-id=\"heading-5\">5.我的</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170ccf021f2413e6?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h2 data-id=\"heading-6\">二.项目简介</h2>\r\n<h3 data-id=\"heading-7\">1.vant Ui库</h3>\r\n<p>在uni-app中使用H5版Ui库\r\n本站采用vant的H5版本(打包小程序和APP请使用vant的小程序版)UI库</p>\r\n<pre><code lang=\"bash\" class=\"copyable\">npm init <span># 初始化package.json文件</span>\r\nnpm i vant -S <span># 通过npm安装vant的H5版本</span>\r\n<span class=\"copy-code-btn\">复制代码</span></code></pre><p>vant H5版本的使用(全局引入)</p>\r\n<p>main.js</p>', 'https://scpic.chinaz.net/files/pic/pic9/202104/bpic23077.jpg', 55, '2021-06-02 18:31:04', NULL, NULL, NULL);
INSERT INTO `mb_article` VALUES ('8', '测试标题2', '<p>本项目纯开源免费, 商品信息均来自网络,如有侵权,请联系作者,我会及时删除!</p>\r\n</blockquote>\r\n<p>前一段,看到一个大佬写的叮咚买菜,挺好,于是乎自己在家也琢磨了一下,自己搞了一版本,记录一些uni-app的开发事项,纯属个人总结,不对之处,还请指教!功能不是很全面,以后决定作为一个系列,持续更新</p>\r\n<h2 data-id=\"heading-0\">一.预览:</h2>\r\n<p>在线预览地址: <a target=\"_blank\" href=\"http://dingdong.nodebook.top/\">dingdong.nodebook.top/</a></p>\r\n<p>GitHub: <a target=\"_blank\" href=\"https://github.com/cgq001/dingdong\">github.com/cgq001/ding…</a></p>\r\n<p>管理后台: <a target=\"_blank\" href=\"http://dingdong-admin.nodebook.top/\">dingdong-admin.nodebook.top/</a></p>\r\n<p>如果你觉得还凑合,给个start怎么样? 我会继续努力完善项目,争取做到前后台完整开源</p>\r\n<h4 data-id=\"heading-1\">1.首页</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170ccefad77bb8b3?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h4 data-id=\"heading-2\">2.分类</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170cceffd61b878c?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h4 data-id=\"heading-3\">3.加入购物车</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170ccf00f900d318?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h4 data-id=\"heading-4\">4.收货地址</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170ccf01837d3a4c?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h4 data-id=\"heading-5\">5.我的</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170ccf021f2413e6?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h2 data-id=\"heading-6\">二.项目简介</h2>\r\n<h3 data-id=\"heading-7\">1.vant Ui库</h3>\r\n<p>在uni-app中使用H5版Ui库\r\n本站采用vant的H5版本(打包小程序和APP请使用vant的小程序版)UI库</p>\r\n<pre><code lang=\"bash\" class=\"copyable\">npm init <span># 初始化package.json文件</span>\r\nnpm i vant -S <span># 通过npm安装vant的H5版本</span>\r\n<span class=\"copy-code-btn\">复制代码</span></code></pre><p>vant H5版本的使用(全局引入)</p>\r\n<p>main.js</p>', 'https://scpic.chinaz.net/files/pic/pic9/202104/bpic23077.jpg', 55, '2021-06-02 18:31:04', NULL, NULL, NULL);
INSERT INTO `mb_article` VALUES ('9', '测试标题2', '<p>本项目纯开源免费, 商品信息均来自网络,如有侵权,请联系作者,我会及时删除!</p>\r\n</blockquote>\r\n<p>前一段,看到一个大佬写的叮咚买菜,挺好,于是乎自己在家也琢磨了一下,自己搞了一版本,记录一些uni-app的开发事项,纯属个人总结,不对之处,还请指教!功能不是很全面,以后决定作为一个系列,持续更新</p>\r\n<h2 data-id=\"heading-0\">一.预览:</h2>\r\n<p>在线预览地址: <a target=\"_blank\" href=\"http://dingdong.nodebook.top/\">dingdong.nodebook.top/</a></p>\r\n<p>GitHub: <a target=\"_blank\" href=\"https://github.com/cgq001/dingdong\">github.com/cgq001/ding…</a></p>\r\n<p>管理后台: <a target=\"_blank\" href=\"http://dingdong-admin.nodebook.top/\">dingdong-admin.nodebook.top/</a></p>\r\n<p>如果你觉得还凑合,给个start怎么样? 我会继续努力完善项目,争取做到前后台完整开源</p>\r\n<h4 data-id=\"heading-1\">1.首页</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170ccefad77bb8b3?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h4 data-id=\"heading-2\">2.分类</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170cceffd61b878c?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h4 data-id=\"heading-3\">3.加入购物车</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170ccf00f900d318?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h4 data-id=\"heading-4\">4.收货地址</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170ccf01837d3a4c?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h4 data-id=\"heading-5\">5.我的</h4>\r\n<p></p><figure><img src=\"https://user-gold-cdn.xitu.io/2020/3/12/170ccf021f2413e6?imageslim\" loading=\"lazy\"><figcaption></figcaption></figure><p></p>\r\n<h2 data-id=\"heading-6\">二.项目简介</h2>\r\n<h3 data-id=\"heading-7\">1.vant Ui库</h3>\r\n<p>在uni-app中使用H5版Ui库\r\n本站采用vant的H5版本(打包小程序和APP请使用vant的小程序版)UI库</p>\r\n<pre><code lang=\"bash\" class=\"copyable\">npm init <span># 初始化package.json文件</span>\r\nnpm i vant -S <span># 通过npm安装vant的H5版本</span>\r\n<span class=\"copy-code-btn\">复制代码</span></code></pre><p>vant H5版本的使用(全局引入)</p>\r\n<p>main.js</p>', 'https://scpic.chinaz.net/files/pic/pic9/202104/bpic23077.jpg', 55, '2021-06-02 18:31:04', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for mb_comment
-- ----------------------------
DROP TABLE IF EXISTS `mb_comment`;
CREATE TABLE `mb_comment`  (
  `id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `article_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '被评论的文章id',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '评论内容',
  `user_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发表评论人id',
  `like_num` int(0) NULL DEFAULT NULL COMMENT '点赞数量',
  `approve_state` int(0) NULL DEFAULT NULL COMMENT '评论审核状态：0待审核 1审核通过 2审核未通过',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '评论表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of mb_comment
-- ----------------------------
INSERT INTO `mb_comment` VALUES ('1', '1', '测试内容', '1', 111111, NULL, '2021-06-29 14:08:48', NULL, NULL, NULL);
INSERT INTO `mb_comment` VALUES ('2', '1', '测试内容', '1', 111111, NULL, '2021-06-29 14:08:48', NULL, NULL, NULL);
INSERT INTO `mb_comment` VALUES ('3', '1', '测试内容', '1', 111111, NULL, '2021-06-29 14:08:48', NULL, NULL, NULL);
INSERT INTO `mb_comment` VALUES ('4', '1', '测试内容', '1', 111111, NULL, '2021-06-29 14:08:48', NULL, NULL, NULL);
INSERT INTO `mb_comment` VALUES ('5', '1', '测试内容', '1', 111111, NULL, '2021-06-29 14:08:48', NULL, NULL, NULL);
INSERT INTO `mb_comment` VALUES ('6', '1', '', '1', 111111, NULL, '2021-06-29 14:08:48', NULL, NULL, NULL);
INSERT INTO `mb_comment` VALUES ('7', '1', '', '1', 111111, NULL, '2021-06-29 14:08:48', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for mb_comment_reply
-- ----------------------------
DROP TABLE IF EXISTS `mb_comment_reply`;
CREATE TABLE `mb_comment_reply`  (
  `id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `comment_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论id',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '评论内容',
  `user_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发表评论人id',
  `replyuser_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '被回复人id',
  `like_num` int(0) NULL DEFAULT NULL COMMENT '点赞数量',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '评论回复表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for mb_permission
-- ----------------------------
DROP TABLE IF EXISTS `mb_permission`;
CREATE TABLE `mb_permission`  (
  `id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `desc` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限描述',
  `permission_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限代码',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of mb_permission
-- ----------------------------
INSERT INTO `mb_permission` VALUES ('1', '菜单1', 'admin:add', NULL, NULL, NULL, NULL);
INSERT INTO `mb_permission` VALUES ('2', '菜单2', 'admin:select', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for mb_role
-- ----------------------------
DROP TABLE IF EXISTS `mb_role`;
CREATE TABLE `mb_role`  (
  `id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名',
  `role_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色代码',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of mb_role
-- ----------------------------
INSERT INTO `mb_role` VALUES ('1', '管理员', 'admin', NULL, NULL, NULL, NULL);
INSERT INTO `mb_role` VALUES ('2', '店长', 'dianzhang', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for mb_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `mb_role_permission`;
CREATE TABLE `mb_role_permission`  (
  `id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色id',
  `permission_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色-权限表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of mb_role_permission
-- ----------------------------
INSERT INTO `mb_role_permission` VALUES ('1', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `mb_role_permission` VALUES ('2', '1', '2', NULL, NULL, NULL, NULL);
INSERT INTO `mb_role_permission` VALUES ('3', '2', '1', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for mb_user
-- ----------------------------
DROP TABLE IF EXISTS `mb_user`;
CREATE TABLE `mb_user`  (
  `id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户加密密码',
  `salt` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '盐值',
  `mobile` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of mb_user
-- ----------------------------
INSERT INTO `mb_user` VALUES ('1', '1', '1', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `mb_user` VALUES ('1397111106262024194', 'qinbo', 'ac8d0c2bd2810b4a197ce10a32493e27', 'kyqsWd7IP4JuP6NQwlnfcw==', '18210384513', '2021-05-25 16:43:39', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for mb_user_role
-- ----------------------------
DROP TABLE IF EXISTS `mb_user_role`;
CREATE TABLE `mb_user_role`  (
  `id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户id',
  `role_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户-角色表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of mb_user_role
-- ----------------------------
INSERT INTO `mb_user_role` VALUES ('1', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `mb_user_role` VALUES ('2', '1', '2', NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
